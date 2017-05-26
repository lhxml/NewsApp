package com.example.bean;

/**
 * Created by lxl on 2017/4/15.
 */

public class NewsDetails {
        /**
         * news_id : 5628
         * title : 阿根廷男子性侵女儿22年生8子
         * top_image : http://img5.cache.netease.com/3g/2016/1/10/2016011015570932721.jpg
         * text_image0 : http:///img1.cache.netease.com/cnews/2016/1/10/201601101549260cae4_550.jpg
         * text_image1 : http:///img3.cache.netease.com/cnews/2016/1/10/201601101549536da93_550.jpg
         * source : 新华网
         * content :
         阿根廷《自由报》社交网站公布“兽父”多明戈·布利西奥被捕画面。（图片来源：互联网）安东尼娅接受媒体采访。（图片来源：互联网）奥地利的“兽父”约瑟夫·弗莱茨勒。（图片来源：互联网）    新华网北京1月10日电 阿根廷一名男子被控性侵女儿22年，并与女儿生下8名孩子，在警方追捕1个月后遭到逮捕。    因与奥地利臭名昭著的“兽父”约瑟夫·弗莱茨勒罪行相似，该男子被媒体称作“阿根廷版弗莱茨勒”。    【性侵女儿22载】</strong>    阿根廷“兽父”名为多明戈·布利西奥，现年56岁，家住在阿根廷圣地亚哥－德尔埃斯特罗省的一个小镇。    据新华国际客户端了解，在妻子带着其他3个孩子离开后，留在布利西奥身边的女儿安东尼娅成为了他的“性奴”。    安东尼娅自9岁起开始遭到父亲的性侵犯或性虐待，现年31岁的她，已和父亲生下8名孩子。    近日，安东尼娅终于成功逃脱父亲并向有关部门求助。    她告诉当地媒体，父亲多次在她的孩子面前对自己施暴。    “在我妈妈离开后，我就成了父亲的‘妻子’，从我9岁起，父亲就开始对我实施性侵，”安东尼娅回忆说，“看到我和某个邻居说话或者是想要对我进行性侵时，他（布利西奥）就会打我，（如果我躲避），他便拿着木块在屋子里追我”。    安东尼娅还称父亲经常威胁自己，如果把性侵的事情告诉别人“就会杀了我”。    新华国际客户端获悉，除父亲外，安东尼娅还遭到了叔叔的性侵犯。    【“阿根廷版弗莱茨勒”】</strong>

         安东尼娅逃跑后，布利西奥也从自家逃离。    英国《每日邮报》8日报道，在警方追捕1个月后，布利西奥终于遭到逮捕。    阿根廷检方表示，布利西奥面临多个强奸罪名指控，调查部门将对布利西奥进行脱氧核糖核酸（DNA）测试以确定8名孩子是否为其亲生。    “我为自己和孩子的命运担忧，因为我收到了父亲兄弟姐妹们的恐吓，他们让我撤销对父亲的控诉，”安东尼娅说，“他们根本不关心发生了什么，但我希望他（布利西奥）进监狱，我希望能够诉诸法律。”    这起事件让人联想到奥地利的“兽父”约瑟夫·弗莱茨勒，他把亲生女儿伊丽莎白囚禁在地下室24年，并对女儿进行性侵犯，使女儿产下7名孩子，他2008年被捕，时年73岁，奥地利一家法院2009年判处弗莱茨勒终身监禁。    作者：刘曦

         * digest : 女儿9岁起被性侵至今31岁，期间还受到叔叔侵犯。
         * reply_count : 396
         * edit_time : 1452412209
         */

        private String news_id;
        private String title;
        private String top_image;
        private String text_image0;
        private String text_image1;
        private String source;
        private String content;
        private String digest;
        private String reply_count;
        private String edit_time;

        public String getNews_id() {
            return news_id;
        }

        public void setNews_id(String news_id) {
            this.news_id = news_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTop_image() {
            return top_image;
        }

        public void setTop_image(String top_image) {
            this.top_image = top_image;
        }

        public String getText_image0() {
            return text_image0;
        }

        public void setText_image0(String text_image0) {
            this.text_image0 = text_image0;
        }

        public String getText_image1() {
            return text_image1;
        }

        public void setText_image1(String text_image1) {
            this.text_image1 = text_image1;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getReply_count() {
            return reply_count;
        }

        public void setReply_count(String reply_count) {
            this.reply_count = reply_count;
        }

        public String getEdit_time() {
            return edit_time;
        }

        public void setEdit_time(String edit_time) {
            this.edit_time = edit_time;
        }

    @Override
    public String toString() {
        return "NewsDetails{" +
                "news_id='" + news_id + '\'' +
                ", title='" + title + '\'' +
                ", top_image='" + top_image + '\'' +
                ", text_image0='" + text_image0 + '\'' +
                ", text_image1='" + text_image1 + '\'' +
                ", source='" + source + '\'' +
                ", content='" + content + '\'' +
                ", digest='" + digest + '\'' +
                ", reply_count='" + reply_count + '\'' +
                ", edit_time='" + edit_time + '\'' +
                '}';
    }
}
