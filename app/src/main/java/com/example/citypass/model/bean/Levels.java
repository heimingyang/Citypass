package com.example.citypass.model.bean;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/24 10:07
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Levels {

    /**
     * code : 1000
     * message : Success
     */

    private MessageListBean MessageList;
    /**
     * MyTLevel : {"MyTLevel":[{"CurrLevel":1,"CIntegral":"你当前等级LV.1(新居民)，成长值0点","CTname":"你当前等级LV.1(新居民)，成长值0点"}],"Count":0}
     * TLevelList : {"TLevelList":[{"Level":"1","TName":"新居民","Integral":"0"},{"Level":"2","TName":"新居民","Integral":"200"},{"Level":"3","TName":"新居民","Integral":"500"},{"Level":"4","TName":"合格市民","Integral":"800"},{"Level":"5","TName":"合格市民","Integral":"1200"},{"Level":"6","TName":"合格市民","Integral":"1600"},{"Level":"7","TName":"模范市民","Integral":"2000"},{"Level":"8","TName":"模范市民","Integral":"3000"},{"Level":"9","TName":"模范市民","Integral":"4000"},{"Level":"10","TName":"小区楼长","Integral":"5000"},{"Level":"11","TName":"小区楼长","Integral":"7000"},{"Level":"12","TName":"小区楼长","Integral":"9000"},{"Level":"13","TName":"小区区长","Integral":"12000"},{"Level":"14","TName":"小区区长","Integral":"15000"},{"Level":"15","TName":"小区区长","Integral":"18000"},{"Level":"16","TName":"居委委员","Integral":"22000"},{"Level":"17","TName":"居委委员","Integral":"26000"},{"Level":"18","TName":"居委委员","Integral":"32000"},{"Level":"19","TName":"居委主任","Integral":"40000"},{"Level":"20","TName":"居委主任","Integral":"50000"},{"Level":"21","TName":"居委主任","Integral":"60000"},{"Level":"22","TName":"街道主任","Integral":"80000"},{"Level":"23","TName":"街道主任","Integral":"100000"},{"Level":"24","TName":"街道主任","Integral":"120000"},{"Level":"25","TName":"政协委员","Integral":"150000"},{"Level":"26","TName":"政协委员","Integral":"200000"},{"Level":"27","TName":"政协委员","Integral":"250000"},{"Level":"28","TName":"人大代表","Integral":"300000"},{"Level":"29","TName":"人大代表","Integral":"400000"},{"Level":"30","TName":"人大代表","Integral":"500000"}],"Count":30}
     */

    private ServerInfoBean ServerInfo;
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"MyTLevel":{"MyTLevel":[{"CurrLevel":1,"CIntegral":"你当前等级LV.1(新居民)，成长值0点","CTname":"你当前等级LV.1(新居民)，成长值0点"}],"Count":0},"TLevelList":{"TLevelList":[{"Level":"1","TName":"新居民","Integral":"0"},{"Level":"2","TName":"新居民","Integral":"200"},{"Level":"3","TName":"新居民","Integral":"500"},{"Level":"4","TName":"合格市民","Integral":"800"},{"Level":"5","TName":"合格市民","Integral":"1200"},{"Level":"6","TName":"合格市民","Integral":"1600"},{"Level":"7","TName":"模范市民","Integral":"2000"},{"Level":"8","TName":"模范市民","Integral":"3000"},{"Level":"9","TName":"模范市民","Integral":"4000"},{"Level":"10","TName":"小区楼长","Integral":"5000"},{"Level":"11","TName":"小区楼长","Integral":"7000"},{"Level":"12","TName":"小区楼长","Integral":"9000"},{"Level":"13","TName":"小区区长","Integral":"12000"},{"Level":"14","TName":"小区区长","Integral":"15000"},{"Level":"15","TName":"小区区长","Integral":"18000"},{"Level":"16","TName":"居委委员","Integral":"22000"},{"Level":"17","TName":"居委委员","Integral":"26000"},{"Level":"18","TName":"居委委员","Integral":"32000"},{"Level":"19","TName":"居委主任","Integral":"40000"},{"Level":"20","TName":"居委主任","Integral":"50000"},{"Level":"21","TName":"居委主任","Integral":"60000"},{"Level":"22","TName":"街道主任","Integral":"80000"},{"Level":"23","TName":"街道主任","Integral":"100000"},{"Level":"24","TName":"街道主任","Integral":"120000"},{"Level":"25","TName":"政协委员","Integral":"150000"},{"Level":"26","TName":"政协委员","Integral":"200000"},{"Level":"27","TName":"政协委员","Integral":"250000"},{"Level":"28","TName":"人大代表","Integral":"300000"},{"Level":"29","TName":"人大代表","Integral":"400000"},{"Level":"30","TName":"人大代表","Integral":"500000"}],"Count":30}}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0283203
     */

    private Object Extend;
    private int Count;
    private int GxNum;
    private int PageNum;
    private double retime;


    public MessageListBean getMessageList() {
        return MessageList;
    }

    public void setMessageList(MessageListBean MessageList) {
        this.MessageList = MessageList;
    }

    public ServerInfoBean getServerInfo() {
        return ServerInfo;
    }

    public void setServerInfo(ServerInfoBean ServerInfo) {
        this.ServerInfo = ServerInfo;
    }

    public Object getExtend() {
        return Extend;
    }

    public void setExtend(Object Extend) {
        this.Extend = Extend;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public int getGxNum() {
        return GxNum;
    }

    public void setGxNum(int GxNum) {
        this.GxNum = GxNum;
    }

    public int getPageNum() {
        return PageNum;
    }

    public void setPageNum(int PageNum) {
        this.PageNum = PageNum;
    }

    public double getRetime() {
        return retime;
    }

    public void setRetime(double retime) {
        this.retime = retime;
    }

    public static class MessageListBean {
        private int code;
        private String message;


        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class ServerInfoBean {
        /**
         * MyTLevel : [{"CurrLevel":1,"CIntegral":"你当前等级LV.1(新居民)，成长值0点","CTname":"你当前等级LV.1(新居民)，成长值0点"}]
         * Count : 0
         */

        private MyTLevelBean MyTLevel;
        /**
         * TLevelList : [{"Level":"1","TName":"新居民","Integral":"0"},{"Level":"2","TName":"新居民","Integral":"200"},{"Level":"3","TName":"新居民","Integral":"500"},{"Level":"4","TName":"合格市民","Integral":"800"},{"Level":"5","TName":"合格市民","Integral":"1200"},{"Level":"6","TName":"合格市民","Integral":"1600"},{"Level":"7","TName":"模范市民","Integral":"2000"},{"Level":"8","TName":"模范市民","Integral":"3000"},{"Level":"9","TName":"模范市民","Integral":"4000"},{"Level":"10","TName":"小区楼长","Integral":"5000"},{"Level":"11","TName":"小区楼长","Integral":"7000"},{"Level":"12","TName":"小区楼长","Integral":"9000"},{"Level":"13","TName":"小区区长","Integral":"12000"},{"Level":"14","TName":"小区区长","Integral":"15000"},{"Level":"15","TName":"小区区长","Integral":"18000"},{"Level":"16","TName":"居委委员","Integral":"22000"},{"Level":"17","TName":"居委委员","Integral":"26000"},{"Level":"18","TName":"居委委员","Integral":"32000"},{"Level":"19","TName":"居委主任","Integral":"40000"},{"Level":"20","TName":"居委主任","Integral":"50000"},{"Level":"21","TName":"居委主任","Integral":"60000"},{"Level":"22","TName":"街道主任","Integral":"80000"},{"Level":"23","TName":"街道主任","Integral":"100000"},{"Level":"24","TName":"街道主任","Integral":"120000"},{"Level":"25","TName":"政协委员","Integral":"150000"},{"Level":"26","TName":"政协委员","Integral":"200000"},{"Level":"27","TName":"政协委员","Integral":"250000"},{"Level":"28","TName":"人大代表","Integral":"300000"},{"Level":"29","TName":"人大代表","Integral":"400000"},{"Level":"30","TName":"人大代表","Integral":"500000"}]
         * Count : 30
         */

        private TLevelListBeans TLevelList;


        public MyTLevelBean getMyTLevel() {
            return MyTLevel;
        }

        public void setMyTLevel(MyTLevelBean MyTLevel) {
            this.MyTLevel = MyTLevel;
        }

        public TLevelListBeans getTLevelList() {
            return TLevelList;
        }

        public void setTLevelList(TLevelListBeans TLevelList) {
            this.TLevelList = TLevelList;
        }

        public static class MyTLevelBean {
            private int Count;
            /**
             * CurrLevel : 1
             * CIntegral : 你当前等级LV.1(新居民)，成长值0点
             * CTname : 你当前等级LV.1(新居民)，成长值0点
             */

            private List<MyTLevelBeans> MyTLevel;


            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<MyTLevelBeans> getMyTLevel() {
                return MyTLevel;
            }

            public void setMyTLevel(List<MyTLevelBeans> MyTLevel) {
                this.MyTLevel = MyTLevel;
            }

            public static class MyTLevelBeans {
                private int CurrLevel;
                private String CIntegral;
                private String CTname;


                public int getCurrLevel() {
                    return CurrLevel;
                }

                public void setCurrLevel(int CurrLevel) {
                    this.CurrLevel = CurrLevel;
                }

                public String getCIntegral() {
                    return CIntegral;
                }

                public void setCIntegral(String CIntegral) {
                    this.CIntegral = CIntegral;
                }

                public String getCTname() {
                    return CTname;
                }

                public void setCTname(String CTname) {
                    this.CTname = CTname;
                }
            }
        }

        public static class TLevelListBeans {
            private int Count;
            /**
             * Level : 1
             * TName : 新居民
             * Integral : 0
             */

            private List<TLevelListBean> TLevelList;


            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<TLevelListBean> getTLevelList() {
                return TLevelList;
            }

            public void setTLevelList(List<TLevelListBean> TLevelList) {
                this.TLevelList = TLevelList;
            }

            public static class TLevelListBean {
                private String Level;
                private String TName;
                private String Integral;


                public String getLevel() {
                    return Level;
                }

                public void setLevel(String Level) {
                    this.Level = Level;
                }

                public String getTName() {
                    return TName;
                }

                public void setTName(String TName) {
                    this.TName = TName;
                }

                public String getIntegral() {
                    return Integral;
                }

                public void setIntegral(String Integral) {
                    this.Integral = Integral;
                }
            }
        }
    }
}
