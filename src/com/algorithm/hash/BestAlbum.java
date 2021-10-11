package com.algorithm.hash;

import java.util.*;

/**
 * [프로그래머스] 베스트앨범
 */
public class BestAlbum {
    static class Music {
        private final String genre;
        private final int play;
        private final int index;

        Music(String genre, int play, int index) {
            this.genre = genre;
            this.play = play;
            this.index = index;
        }

        public int getPlay() {
            return this.play;
        }

        public int getIndex() {
            return this.index;
        }

        public String getGenre() {
            return this.genre;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생된 횟수
        Map<String, Integer> totalGenres = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalGenres.put(genres[i], totalGenres.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 장르별 top 재생 목록
        List<Map.Entry<String, Integer>> topGenres = new ArrayList<>(totalGenres.entrySet());
        topGenres.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        // 장르별 노래 목록(노래 목록은 재생순)
        Map<String, List<Music>> musicGenres = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            List<Music> musics = musicGenres.getOrDefault(genre, new ArrayList<>());
            musics.add(new Music(genre, plays[i], i));
            musics.sort((m1, m2) -> m2.getPlay() - m1.getPlay());
            musicGenres.put(genre, musics);
        }

        // 베스트 앨범에 들어갈 노래 선별
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> topGenre : topGenres) {
            String genre = topGenre.getKey();
            int count = 0;
            for (Music music : musicGenres.get(genre)) {
                if (count == 2) break;

                answer.add(music.getIndex());
                count++;
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

}
