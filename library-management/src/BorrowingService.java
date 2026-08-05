public class BorrowingService {
    private BookService bookService;

    public BorrowingService(BookService bookService) {
        this.bookService = bookService;
    }

    public void borrow(String cardNo, String isbn) throws BookNotFoundException,BookNotAvailableException {
        if(cardNo == null){
            throw new IllegalArgumentException("借书证号格式错误：不能为空！");
        }else if(cardNo.length() != 8){
            throw new IllegalArgumentException("借书证号格式错误：必须为8位数字！当前 " + cardNo.length() + "位");
        }

        for(int i = 0; i < cardNo.length(); i++){
            if(!Character.isDigit(cardNo.charAt(i))){
                throw new IllegalArgumentException("借书证号格式错误：必须全为数字！");
            }
        }

        String message = BookValidator.validate(isbn, Book.class.getName());

        if(message != null){
            throw new IllegalArgumentException(message);
        }

        Book book = bookService.findByIsbn(isbn);

        if (book == null){
            throw new BookNotFoundException("找不到 ISBN " + isbn + " 的书");
        }

        if (book.isBorrowed()){
            throw new BookNotAvailableException("这本书已被借出");
        }

        book.borrow();
        System.out.println("借书成功" + book.getTitle());
    }

    public void returnBook(String isbn, int overdueDays) throws BookNotFoundException{
        Book book = bookService.findByIsbn(isbn);
        if(book == null){
            throw new BookNotFoundException("找不到 ISBN " + isbn + " 的书");
        }

        book.returnBook();

        double fine = OverdueFineCalculator.calculateFine(overdueDays);

        if (fine > 0) {
            System.out.println("逾期罚款 " + fine + " 元");
        } else {
            System.out.println("还书成功，无罚款");
        }
    }
}
