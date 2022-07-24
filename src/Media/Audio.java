package Media;


import Media.Features.play;

public class Audio extends Media implements play{
	private int duration;
	private int volume = 5;

	public Audio(String title, int duration) {
		super(title);
		this.duration = duration;
		
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public void turnUpVolume() {
		int volume = getVolume();
		volume++;
		setVolume(volume);
	}

	public void turnDownVolume() {
		int volume = getVolume();
		volume--;
		setVolume(volume);
	}
	
	@Override
	public void play() {
		for (int i = 0; i<getDuration(); i++) {
			String volumeSymbols = "";
			for (int x = 0; x < getVolume(); x++) {
				volumeSymbols += "!";
			}
			System.out.println(getTitle() + " " + volumeSymbols);
		}
		
	}

}   