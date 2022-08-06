import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.time.LocalDate;

public class VerseOfTheDay {

	public VerseOfTheDay(Scanner sc) {
		System.out.println("Verse Of The Day\n");
		LocalDate today = LocalDate.now();
		if (verseOfDayIsCurrent(sc)) {
			System.out.println("true");
		}
		//	if there is no verse of the day, create a verse of the day
		try {
			Formatter todaysVerse = new Formatter("verseoftheday.txt");

			todaysVerse.format("%s", today + "\n" + getRandomVerse(sc));
			todaysVerse.close();

		} catch (FileNotFoundException e) {
			System.out.println("verse of the day is having troubles with files");
		}
	}


	String getRandomVerse(Scanner sc) {

		Bible bible = new Bible();
		Random random = new Random();
		int randomBookNum = random.nextInt(bible.books.length);

		//System.out.println("randomBookNum is: " + randomBookNum);

		String randomBook = bible.books[randomBookNum];

		int randomChapterNum = random.nextInt(bible.getBookLength(sc, bible.books[randomBookNum])) + 1;

		//System.out.println("randomChapterNum is: " + randomChapterNum);

		int randomVerseNum = random.nextInt(bible.getChapterLength(sc, bible.books[randomBookNum], randomChapterNum)) + 1;

		//System.out.println("randomVerseNum is: " + randomVerseNum);

		String bookOfVerse = bible.books[randomBookNum].replace(".txt", "").replace("_", " ").toUpperCase() + "\n";

		String randomVerse = bookOfVerse + bible.getVerse(sc, randomBook, randomChapterNum, randomVerseNum) + "\n";
		return randomVerse;
	}

	public boolean verseOfDayExists() {
		//checks if file verseoftheday.txt exists

		try {
			File file = new File("verseoftheday.txt");
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean verseOfDayIsCurrent(Scanner sc) {
		if (verseOfDayExists()) {
			try {
				File f = new File("verseoftheday.txt");
				LocalDate today = LocalDate.now();
				String now = today + "";
				sc = new Scanner(f);
				while (sc.hasNextLine()) {
					String l = sc.nextLine();
					if (l.equals(now)) {
						return true;

					}

				}
			} catch (FileNotFoundException e) {
				System.out.println("file error");
			}
		}
		return false;
	}

}