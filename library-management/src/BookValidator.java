public class BookValidator {
    public static String validate(String isbn, String title){
        if(isbn == null){
            return "ISBN 不能为空！";
        } else if (isbn.length() != 13){
            return "ISBN 长度必须为 13 位，当前 " + isbn.length() + "位";
        }else if (!(isbn.startsWith("978") || isbn.startsWith("979"))){
            return "ISBN 必须以 “978” 或 “979” 开头！";
        }else if (title == null){
            return "书名不能为空！";
        } else if (title.isBlank()){
            return "书名不能为空！";
        }
        return null;
    }
}
