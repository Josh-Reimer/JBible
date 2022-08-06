import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

public class VerseOfTheDay {

	public VerseOfTheDay() {
		//Formatter todaysVerse = new Formatter("verseoftheday.txt");


	}


	String getRandomVerse(Scanner sc) {
System.out.println("Verse Of The Day\n");
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
}