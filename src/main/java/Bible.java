import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Bible {
	public String pathToBible = "/storage/emulated/0/Java/JBible/bible/";
	//above file path is an the full path to the Bible text files on my Android phone
	//you must change it to the path where you put the Bible text files
	public String[] books = {"genesis.txt", "exodus.txt", "leviticus.txt", "numbers.txt", "deuteronomy.txt", "joshua.txt", "judges.txt", "ruth.txt", "first_samuel.txt", "second_samuel.txt", "first_kings.txt", "second_kings.txt", "first_chronicles.txt", "second_chronicles.txt", "ezra.txt", "nehemiah.txt", "esther.txt", "job.txt", "psalms.txt", "proverbs.txt", "eccliasiastes.txt", "song_of_solomon.txt", "isaiah.txt", "jeremiah.txt", "lamentations.txt", "ezekial.txt", "daniel.txt", "hosea.txt", "joel.txt", "amos.txt", "obadiah.txt", "jonah.txt", "micah.txt", "nahum.txt", "habakkuk.txt", "zephaniah.txt", "haggai.txt", "zechariah.txt", "malachi.txt", "matthew.txt", "mark.txt", "luke.txt", "john.txt", "acts.txt", "romans.txt", "first_corinthians.txt", "second_corinthians.txt", "galatians.txt", "ephesians.txt", "philipians.txt", "colossians.txt", "first_thesselonians.txt", "second_thesselonians.txt", "first_timothy.txt", "second_timothy.txt", "titus.txt", "philemon.txt", "hebrews.txt", "james.txt", "first_peter.txt", "second_peter.txt", "first_john.txt", "second_john.txt", "third_john.txt", "jude.txt", "revelation.txt"};
	public void getBible(Scanner studyaide) {

		try {
			File Bible = new File(pathToBible + "Bible.txt");
			studyaide = new Scanner(Bible);
			while (studyaide.hasNextLine()) {
				String line = studyaide.nextLine();
				System.out.println(line);
			}

		} catch (FileNotFoundException e) {
			System.out.println("getBible() could not load file");

		}
	}
	public String getBibleAsString(Scanner studyaide) {
		String book = "";
		try {
			File Bible = new File(pathToBible + "Bible.txt");
			studyaide = new Scanner(Bible);
			while (studyaide.hasNextLine()) {
				String line = studyaide.nextLine();
				book = book + line + "\n";
			}

		} catch (FileNotFoundException e) {
			System.out.println("getBible() could not load file");

		}
		return book;
	}
	public void listbooks() {
		for (String book : books) {
			System.out.println(book);
		}
	}
	public String getBook(Scanner sc, String book) {
		//book must have file extsn
		String rString = "";
		try {

			File fileObject = new File(pathToBible + book);
			sc = new Scanner(fileObject);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();

				rString = rString + "\n" + line + "\n";
			}

		} catch (FileNotFoundException e) {
			System.out.println("getBook() could not load file");
		}

		return rString;
	}
	public String getChapter(Scanner sc, String book, int chapter) {
		String chap = "";
		try {
			File bookObject = new File(pathToBible + book);
			sc = new Scanner(bookObject);

			while (sc.hasNextLine()) {
				String line = sc.nextLine();

				String chapnum = line.split(":")[0];
				String chapnumstring = Integer.toString(chapter);

				if (chapnum.equals(chapnumstring)) {
					chap = chap + line + "\n";
				} else {
					continue;
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("getChapter() could not load file");
		}
		return chap;
	}
	public String getVerse(Scanner sc, String book, int chapter, int verse) {
		String sChapter = getChapter(sc, book, chapter);
		String[] verses = sChapter.split("\n");
		return verses[verse - 1];
	}

	public int getChapterLength(Scanner sc, String book, int chapter) {
		Tools tool = new Tools();
		String chapterstring = getChapter(sc, book, chapter);
		String[] lines = chapterstring.split("\n");
		int chapterlength = lines.length;
		return chapterlength;
	}

	public int getBookLength(Scanner sc, String book) {
		try {
			File bookObject = new File(pathToBible + book);
			sc = new Scanner(bookObject);
			String lastline = "";
			while (sc.hasNextLine()) {
				lastline = sc.nextLine();
			}
			return Integer.parseInt(lastline.split(":")[0]);
		} catch (FileNotFoundException e) {
			System.out.println("file error");
		}
		return 0;
	}

}