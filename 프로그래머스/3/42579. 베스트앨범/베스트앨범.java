// 1. 많이 재생된 장르 먼저 수록
// 2. 그 장르 내에서 많이 재생된 노래 수록
//     재생 횟수가 같다면 고유 번호가 낮은 순으로 수록

import java.util.*;

class Song {
    int index;
    int play;
    
    Song(int index, int play) {
        this.index = index;
        this.play = play;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, List<Song>> map = new HashMap<>();
        Map<String, Integer> genreMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            Song song = new Song(i, plays[i]);
            
            if (map.get(genres[i]) == null) {
                 List<Song> list = new ArrayList<>();
                list.add(song);
                
                map.put(genres[i], list);
            } else {
                map.get(genres[i]).add(song);
            }
            
            
            if (genreMap.get(genres[i]) == null) {
                genreMap.put(genres[i], plays[i]);
            } else {
                genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);
            }
        }
        
        List<String> keys = new ArrayList<>(genreMap.keySet());
        
        keys.sort((o1, o2) -> genreMap.get(o2) - genreMap.get(o1));
        
        int count = 0;
        for(String key : keys) {
            if (map.get(key).size() > 1) {
                count += 2;
            } else {
                count += 1;
            }
        }
        
        int[] answer = new int[count];
        int index = 0;
        
        for(String key : keys) {
            map.get(key).sort((o1, o2) ->  {
                if (o1.play < o2.play) {
                    return 1;
                } else if (o1.play == o2.play) {
                    if (o1.index > o2.index) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            });
            
            if (map.get(key).size() > 1) {
                answer[index++] = map.get(key).get(0).index;
                answer[index++] = map.get(key).get(1).index;
            } else {
                answer[index++] = map.get(key).get(0).index;
            }
            
        }
        
        return answer;
    }
}