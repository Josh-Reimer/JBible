import java.util.Scanner;
public class get {
	public static void main(String[] args) {
		if (args.length >= 1 && args.length <= 3) {
			String book = "";
			int chapter = 0;
			int verse = 0;
			Scanner sc = new Scanner(System.in);
			Bible bible = new Bible();
			Tools tool = new Tools();
			if (tool.isBook(args[0])) {
				book = args[0];
			}
			if (args.length > 1) {
				if (tool.isDigit(args[1])) {
					chapter = Integer.parseInt(args[1]);
				}
				if (args.length > 2) {
					if (tool.isDigit(args[2])) {
						verse = Integer.parseInt(args[2]);
					}
				}
			}
			if (verse != 0) {
				//if there is a verse, there will be a book and chapter
				System.out.println(bible.getVerse(sc, book + ".txt", chapter, verse));
			} else {
				//if there is no verse check for a chapter
				if (chapter != 0) {
					System.out.println(bible.getChapter(sc, book + ".txt", chapter));
				} else if (book != "") {
//if there is no chapter check for a book
					System.out.println(bible.getBook(sc, book+".txt"));
				}
			}
			sc.close();
		}
	}
}