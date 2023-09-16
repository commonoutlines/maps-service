package commonoutlines.com.mapservice;

public class SimpleJSONResponse {
        private String message;
        private String moreData;

        public SimpleJSONResponse(String message, String moreData) {
            this.message = message;
            this.moreData = moreData;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMoreData() {
        return moreData;
        }

        public void setMoreData(String moreData) {
        this.moreData = moreData;
        }


}
