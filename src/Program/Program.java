package Program;

import java.util.Scanner;
import Media.Audio;
import Media.Image;
import Media.Media;
import Media.Video;
import Media.Features.play;
import Media.Features.show;

public class Program {

	public static void main(String[] args) {
		String title;
		int duration;
		int ChooseMedia;
		Media[] media = new Media[5];
		
		Scanner keyboardScanner = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			boolean status = true;
			while (status) {
				System.out.println("Aggiungi 5 file multimediali al tuo lettore.");
				System.out.println("Il tuo lettore contiene " + i + " file multimediali, ne mancano ancora " + (5 - i) + ".");
				System.out.println("Digita 1 per aggiungere un audio.");
				System.out.println("Digita 2 per aggiungere un video.");
				System.out.println("Digita 3 per aggiungere un immagine.");	
				ChooseMedia = keyboardScanner.nextInt();
				keyboardScanner.nextLine();
				switch (ChooseMedia) {
				case 1:
					System.out.println("Dai un titolo al tuo audio.");
					title = keyboardScanner.nextLine();
					System.out.println("Inserisci la durata in secondi del tuo audio: " + title + ".");
					duration = keyboardScanner.nextInt();
					keyboardScanner.nextLine();
					media[i] = new Audio(title, duration);
					status = false;
					break;
				case 2:
					System.out.println("Dai un titolo al tuo video. ");
					title = keyboardScanner.nextLine();
					System.out.println("Inserisci la durata in secondi del tuo video: " + title + ".");
					duration = keyboardScanner.nextInt();
					keyboardScanner.nextLine();
					media[i] = new Video(title, duration);
					status = false;
					break;
				case 3:
					System.out.println("Dai un titolo alla tua foto.");
					title = keyboardScanner.nextLine();
					media[i] = new Image(title);
					status = false;
					break;
				default:
					System.err.println("Inserisci un numero da 1 a 3 per aggiungere un file multimediale.");
					break;
				}
		  }
		
	}
	int ChooseAMedia = 0;
	while (true) {
		System.out.println("Seleziona un file multimediale tra 1 e 5 o Inserisci 0 per uscire!");
		for (int i = 0; i < 5; i++) {
			System.out.println((i + 1) + ")" + media[i].getTitle());
		}
		ChooseAMedia = keyboardScanner.nextInt();
		keyboardScanner.nextLine();
		if(ChooseAMedia < 0 | ChooseAMedia > 5) {
			System.err.println("Scegli un file tra 1 e 5.");	
		}
		else if(ChooseAMedia == 0) {
			System.out.println("Lettore multimediale spento.");
			break;
		}
		playOrShow(media[ChooseAMedia - 1]);
		System.out.println("Vuoi modificare il file? Inserisci SI per confermare.");
		String choice = keyboardScanner.nextLine();
		if (choice.equalsIgnoreCase("SI")) {
			if (media[ChooseAMedia - 1] instanceof Video) {
				boolean Status2 = true;
				int chosenAnswer;
				while (Status2) {
					System.out.println("Inserisci 1 per modificare il volume. Inserisci 2 per modificare la luminosità.");
					chosenAnswer = keyboardScanner.nextInt();
					keyboardScanner.nextLine();
					switch (chosenAnswer) {
					case 1:
						System.out.println("Vuoi aumentare il volume? Inserisci SI per confermare o premi invio per andare avanti.");
						choice = keyboardScanner.nextLine();
						if (choice.equalsIgnoreCase("SI")) {
							((Video) media[ChooseAMedia - 1]).turnUpVolume();
							System.out.println("Hai appena aumentato il volume di 1.");
						} else {
							System.out.println("Vuoi abbassare il volume? Inserisci SI per confermare o premi invio per tornare al menù.");
							choice = keyboardScanner.nextLine();
							if (choice.equalsIgnoreCase("SI")) {
								((Video) media[ChooseAMedia - 1]).turnDownVolume();
								System.out.println("Hai appena abbassato il volume di 1.");
							}
						}
						Status2=false;
						break;
					case 2:
						System.out.println("Vuoi aumentare la luminosità? Inserisci SI per confermare o premi invio per andare avanti.");
						choice = keyboardScanner.nextLine();
						if (choice.equalsIgnoreCase("SI")) {
							((Video) media[ChooseAMedia - 1]).turnUpBrightness();
							System.out.println("Hai appena aumentato la luminosità di 1.");
						} else {
							System.out.println("Vuoi abbassare la luminosità? Inserisci SI per confermare o premi invio per tornare al menù.");
							choice = keyboardScanner.nextLine();
							if (choice.equalsIgnoreCase("SI")) {
								((Video) media[ChooseAMedia - 1]).turnDownBrightness();
								System.out.println("Hai appena abbassato la luminosità di 1.");
							}
						}
						Status2=false;
						break;
					default:
						System.err.println("Inserisci nuovamente! ");
						break;
					}
				}
			} else if (media[ChooseAMedia - 1] instanceof Audio) {
				System.out.println("Vuoi aumentare il volume? Inserisci SI per confermare o premi invio per andare avanti.");
				choice = keyboardScanner.nextLine();
				if (choice.equalsIgnoreCase("SI")) {
					((Audio) media[ChooseAMedia - 1]).turnUpVolume();
					System.out.println("Hai appena aumentato il volume di 1.");
				} else {
					System.out.println("Vuoi abbassare il volume? Inserisci SI per confermare o premi invio per tornare al menù.");
					choice = keyboardScanner.nextLine();
					if (choice.equalsIgnoreCase("SI")) {
						((Audio) media[ChooseAMedia - 1]).turnDownVolume();
						System.out.println("Hai appena abbassato il volume di 1.");
					}
				}
			} else if (media[ChooseAMedia - 1] instanceof Image) {
				System.out.println("Vuoi aumentare la luminosità? Inserisci SI per confermare o premi invio per andare avanti.");
				choice = keyboardScanner.nextLine();
				if (choice.equalsIgnoreCase("SI")) {
					((Image) media[ChooseAMedia - 1]).turnUpBrightness();
					System.out.println("Hai appena aumentato la luminosità di 1.");
				} else {
					System.out.println("Vuoi abbassare la luminosità? Inserisci SI per confermare o premi invio per tornare al menù.");
					choice = keyboardScanner.nextLine();
					if (choice.equalsIgnoreCase("SI")) {
						((Image) media[ChooseAMedia - 1]).turnDownBrightness();
						System.out.println("Hai appena abbassato la luminosità di 1.");
					}
				}
			} 
		}

	}
}
	public static void playOrShow(Media m) {
		if (m instanceof show) {
			((show) m).show();
		} else if (m instanceof play) {
			((play) m).play();
		}

	}
}
