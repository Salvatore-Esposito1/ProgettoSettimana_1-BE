package Media;

import Media.Features.play;
import Media.Features.show;

public class Video extends Media implements play {
	private int duration;
	public int volume = 5;
	public int brightness = 5;
	
	public Video(String title,int duration) {
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

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	public void turnUpBrightness() {
		int brightness = getBrightness();
		brightness++;
		setBrightness(brightness);
	}

	public void turnDownBrightness() {
		int brightness = getBrightness();
		brightness--;
		setBrightness(brightness);

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
			String brightnessSymbols = "";
			for (int x = 0; x <getBrightness(); x++) {
				brightnessSymbols += "*";
			}
			String volumeSymbols = "";
			for (int y = 0; y < getVolume(); y++) {
				volumeSymbols += "!";
			}
			System.out.println(getTitle() + " " + brightnessSymbols + " " + volumeSymbols);
		
		}
	}
}
