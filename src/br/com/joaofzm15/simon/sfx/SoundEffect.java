package br.com.joaofzm15.simon.sfx;

public class SoundEffect implements Runnable {

	private SoundEffectConverter soundEffectConverter;
	private String soundPath;

	public SoundEffect(String url) {
		soundEffectConverter = new SoundEffectConverter();
		soundPath = url;
	}

	@Override
	public void run() {
		soundEffectConverter.setFile(soundPath);
		soundEffectConverter.play();
	}

}
