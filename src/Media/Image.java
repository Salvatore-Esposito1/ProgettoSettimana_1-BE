package Media;

import Media.Features.show;

public class Image extends Media implements show{
	public int brightness = 5;
	
	public Image(String title) {
		super(title);
		
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
	
	@Override
	public void show() {
		String brightnessSymbols = "";
		for (int i = 0; i <getBrightness(); i++) {
			brightnessSymbols += "*";
		}

		System.out.println(getTitle() + " " + brightnessSymbols);
	}

}
