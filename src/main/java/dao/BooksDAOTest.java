package dao;

import java.util.List;

import model.Book;

public class BooksDAOTest {
    public static void main(String[] args) {
        BooksDAO dao = new BooksDAO();
        List<Book> list = dao.findAll();

        if (list != null && !list.isEmpty()) {
            System.out.println("✅ データ取得成功！件数：" + list.size());
            for (Book b : list) {
                System.out.println("ID：" + b.getBook_id());
                System.out.println("タイトル：" + b.getTitle());
                System.out.println("著者：" + b.getAuthor());
                System.out.println("ジャンル：" + b.getGenre1() + "／" + b.getGenre2() + "／" + b.getGenre3());
                System.out.println("あらすじ：" + b.getSynopsis());
                System.out.println("画像パス：" + b.getImagePath());
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("⚠️ データが取得できませんでした。");
        }
    }
}
