class Solution {
    private int toSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    private String toMmSs(int seconds) {
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLength = toSeconds(video_len);
        int position = toSeconds(pos);
        int opStart = toSeconds(op_start);
        int opEnd = toSeconds(op_end);

        for (String command : commands) {
            if (opStart <= position && position <= opEnd) {
                position = opEnd;
            }
            
            if ("prev".equals(command)) {
                position = Math.max(0, position - 10);
            } else if ("next".equals(command)) {
                position = Math.min(videoLength, position + 10);
            }
            
            if (opStart <= position && position <= opEnd) {
                position = opEnd;
            }
        }

        return toMmSs(position);
    }
}