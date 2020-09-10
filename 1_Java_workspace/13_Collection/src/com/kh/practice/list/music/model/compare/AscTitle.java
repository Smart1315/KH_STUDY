package com.kh.practice.list.music.model.compare;

import java.util.Comparator;

import com.kh.practice.list.music.model.vo.Music;

public class AscTitle implements Comparator<Music> {

	@Override
	public int compare(Music o1, Music o2) {
		String standardTitle = o1.getTitle();
		String objectTitle = o2.getTitle();

		int res = standardTitle.compareTo(objectTitle);
		if (res != 0) {
			return res;
		} else {
			return o1.getSinger().compareTo(o2.getSinger());
		}

	}

}
