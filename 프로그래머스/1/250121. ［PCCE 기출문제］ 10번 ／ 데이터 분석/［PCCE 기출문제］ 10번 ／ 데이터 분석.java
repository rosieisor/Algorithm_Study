import java.util.*;

class Data {
    int code;
    int date;
    int maximum;
    int remain;
    
    Data (int code, int date, int maximum, int remain) {
        this.code = code;
        this.date = date;
        this.maximum = maximum;
        this.remain = remain;
    }
}

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<Data> dataList = new ArrayList<>();
        
        switch(ext) {
            case "code":
                for(int i=0; i<data.length; i++) {
                    if (data[i][0] < val_ext) {
                        dataList.add(new Data(data[i][0], data[i][1], data[i][2], data[i][3]));
                    }
                }
                break;
            case "date":
                for(int i=0; i<data.length; i++) {
                    if (data[i][1] < val_ext) {
                        dataList.add(new Data(data[i][0], data[i][1], data[i][2], data[i][3]));
                    }
                }
                break;
            case "maximum":
                for(int i=0; i<data.length; i++) {
                    if (data[i][2] < val_ext) {
                        dataList.add(new Data(data[i][0], data[i][1], data[i][2], data[i][3]));
                    }
                }
                break;
            case "remain":
                for(int i=0; i<data.length; i++) {
                    if (data[i][3] < val_ext) {
                        dataList.add(new Data(data[i][0], data[i][1], data[i][2], data[i][3]));
                    }
                }
                break;
        }
        
        switch(sort_by) {
            case "code":
                Collections.sort(dataList, (o1, o2) -> {
                    if(o1.code > o2.code) {
                        return 1;
                    } else {
                        return -1;
                    }
                });
                break;
            case "date":
                Collections.sort(dataList, (o1, o2) -> {
                    if(o1.date > o2.date) {
                        return 1;
                    } else {
                        return -1;
                    }
                });
                break;
            case "maximum":
                Collections.sort(dataList, (o1, o2) -> {
                    if(o1.maximum > o2.maximum) {
                        return 1;
                    } else {
                        return -1;
                    }
                });
                break;
            case "remain":
                Collections.sort(dataList, (o1, o2) -> {
                    if(o1.remain > o2.remain) {
                        return 1;
                    } else {
                        return -1;
                    }
                });
                break;
        }
        
        int[][] answer = new int[dataList.size()][4];
        
        for(int i=0; i<dataList.size(); i++) {
            answer[i][0] = dataList.get(i).code;
            answer[i][1] = dataList.get(i).date;
            answer[i][2] = dataList.get(i).maximum;
            answer[i][3] = dataList.get(i).remain;
        }
        
        
        return answer;
    }
}