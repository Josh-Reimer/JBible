import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner mainScanner = new Scanner(System.in);
		Bible bible = new Bible();

		VerseOfTheDay v = new VerseOfTheDay();

		System.out.println(v.getRandomVerse(mainScanner));
		Tools tools = new Tools();


		System.out.println("Welcome to Java Bible!\ntype in a command (for example, help) to begin...");

		while (true) {
			System.out.println("enter command\n-->");
			String requestedBook = "";
			int requestedChapter = 0;
			int requestedVerse = 0;
			String command = mainScanner.nextLine().toLowerCase().trim();

			if (command.equals("help")) {
				System.out.println("commands possible are:\n1. exit\n2. bible\n3. random\n4.<book> <chapter> <verse>\n5. list");
			} else if (command.equals("random")) {

				System.out.println(v.getRandomVerse(mainScanner));
			} else if (command.equals("list")) {
				bible.listbooks();
			} else if (command.equals("exit")) {
				System.exit(0);
				break;

			} else if (command.equals("bible")) {
				bible.getBible(mainScanner);

			} else if (tools.isBook(command.replace(" ", "_"))) {

				System.out.println(bible.getBook(mainScanner, command.replace(" ", "_") + ".txt"));

			} else if (tools.isBookChapter(command)) {

				if (tools.isSpaceBook(command)) {
					command = tools.replaceFirstSpace(command);
					System.out.println("is space book");
				}
				requestedBook = command.split(" ")[0] + ".txt";
				requestedChapter = Integer.parseInt(command.split(" ")[1].trim());
				System.out.println(bible.getChapter(mainScanner, requestedBook, requestedChapter));

			} else if (tools.isBookChapterVerse(command)) {
				if (tools.isSpaceBook(command)) {
					command = tools.replaceFirstSpace(command);
				}
				requestedBook = command.split(" ")[0] + ".txt";
				requestedChapter = Integer.parseInt(command.split(" ")[1].trim());
				requestedVerse = Integer.parseInt(command.split(" ")[2].trim());
				System.out.println(bible.getVerse(mainScanner, requestedBook, requestedChapter, requestedVerse));

			} else {
				System.out.println("invalid input");
			}


		}
//end of while loop below
		mainScanner.close();
	}

}