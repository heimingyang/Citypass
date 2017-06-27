package com.example.citypass.model;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/27 8:42
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Medal {

    /**
     * code : 1000
     * message : Success
     */

    private MessageListBean MessageList;
    /**
     * TUserMedalList : {"TUserMedalList":[],"Count":0}
     * TUserCanBeLitMedalList : {"TUserCanBeLitMedalList":[],"Count":0}
     * TMedalList : {"TMedalList":[{"MID":2,"sName":"交友族","Description":"关注他人达200人可获得，终身有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122316020555206722.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210252575158430.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"(点亮后30天有效)","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":3,"sName":"红人","Description":"粉丝人数达200人可获得，终身有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315513119670428.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210250753957944.png","IProgress":"0","DCoin":"50","DIntegral":"300","Effectivetime":"(点亮后30天有效)","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":4,"sName":"打赏族","Description":"近30天内，打赏他人达100城市币可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315504484486071.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210242085306376.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":5,"sName":"土豪","Description":"近30天内，向美女送礼物价值达300城市币可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315495651222363.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210233288215362.png","IProgress":"0","DCoin":"30","DIntegral":"200","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":7,"sName":"发帖狂","Description":"近30天内，发帖数量达20篇可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122316000931217859.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210225709654297.png","IProgress":"0","DCoin":"30","DIntegral":"200","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":8,"sName":"点赞控","Description":"近30天内，点赞照片、文章数达100个可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151224/2015122410383954945138.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210224011541926.png","IProgress":"0","DCoin":"10","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":10,"sName":"闹闹星","Description":"近30天内，在闹闹回复达50条可获得，点亮后30天有效","Image":"http://p5.pccoo.cn/vote/20160728/2016072818490700682566.png","HImage":"http://p5.pccoo.cn/vote/20160728/2016072818492177962998.png","IProgress":"0","DCoin":"30","DIntegral":"150","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":12,"sName":"沙发侠","Description":"近30天内，抢到沙发数达5次可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315481994799019.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210214185401722.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":13,"sName":"板凳侠","Description":"近30天内，抢到板凳数达5次可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315472655231527.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210152714907534.png","IProgress":"0","DCoin":"15","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":14,"sName":"马扎侠","Description":"近30天内，抢到马扎数达5次可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315461788239469.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210204410775834.png","IProgress":"0","DCoin":"10","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":15,"sName":"有态度","Description":"近30天内，对城事文章发表评论达20条可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315571631945525.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210202012280327.png","IProgress":"0","DCoin":"30","DIntegral":"150","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":17,"sName":"神评论","Description":"近30天内，对城事发表评论获得100以上点赞可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315561450888088.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210193515962413.png","IProgress":"0","DCoin":"50","DIntegral":"200","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":18,"sName":"分享使者","Description":"近30天内，分享数达20次可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151224/2015122410344467511294.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210191566698150.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":23,"sName":"封面女郎","Description":"终身勋章\u2014\u2014用户被管理员（编辑）在后台设为\u201c封面女郎\u201d后，将自动获得该勋章。并在其个人主页获得明显标识。","Image":"http://p3.pccoo.cn/vote/20151224/2015122410321418300660.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210184626303240.png","IProgress":"0","DCoin":"100","DIntegral":"300","Effectivetime":"(点亮后30天有效)","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":25,"sName":"封面萌宝","Description":"终身勋章\u2014\u2014用户被管理员（编辑）在后台设为\u201c封面萌宝\u201d后，将自动获得该勋章。并在其个人主页获得明显标识。","Image":"http://p3.pccoo.cn/vote/20151223/2015122315402541631467.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210183122847294.png","IProgress":"0","DCoin":"100","DIntegral":"300","Effectivetime":"(点亮后30天有效)","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":26,"sName":"榜上有名","Description":"近30天内，收到礼物价值达500城市币的美女可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315393667420807.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210175388401089.png","IProgress":"0","DCoin":"50","DIntegral":"200","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":28,"sName":"闹闹帝","Description":"近30天内，在闹闹发贴达20篇可获得，点亮后30天有效","Image":"http://p5.pccoo.cn/vote/20160728/2016072818474416121573.png","HImage":"http://p5.pccoo.cn/vote/20160728/2016072818480374160094.png","IProgress":"0","DCoin":"40","DIntegral":"200","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":29,"sName":"闹闹王","Description":"30天内获得回复50条可获得，点亮后30天有效","Image":"http://p5.pccoo.cn/vote/20160728/2016072818445484892062.png","HImage":"http://p5.pccoo.cn/vote/20160728/2016072818464479589028.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":30,"sName":"爱潜水","Description":"近30天内浏览次数达到100次可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151224/2015122410451968647127.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210164783658104.png","IProgress":"7","DCoin":"10","DIntegral":"30","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":60,"sName":"封面男神","Description":"终身勋章\u2014\u2014用户被管理员（编辑）在后台设为\u201c封面男神\u201d后，将自动获得该勋章。并在其个人主页获得明显标识。","Image":"http://p4.pccoo.cn/vote/20160509/2016050915445655735278.png","HImage":"http://p4.pccoo.cn/vote/20160509/2016050915444481798129.png","IProgress":"0","DCoin":"100","DIntegral":"300","Effectivetime":"(点亮后30天有效)","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":61,"sName":"捧场王","Description":"近30天内，在论坛评论达50条可获得，点亮后30天有效","Image":"http://p4.pccoo.cn/vote/20160509/2016050917065266756114.png","HImage":"http://p4.pccoo.cn/vote/20160509/2016050917062314988355.png","IProgress":"0","DCoin":"30","DIntegral":"150","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":62,"sName":"名人堂","Description":"30天内获得评论50条可获得，点亮后30天有效","Image":"http://p4.pccoo.cn/vote/20160509/2016050917081766543563.png","HImage":"http://p4.pccoo.cn/vote/20160509/2016050917075270311123.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"}],"Count":22}
     */

    private ServerInfoBean ServerInfo;
    /**
     * MessageList : {"code":1000,"message":"Success"}
     * ServerInfo : {"TUserMedalList":{"TUserMedalList":[],"Count":0},"TUserCanBeLitMedalList":{"TUserCanBeLitMedalList":[],"Count":0},"TMedalList":{"TMedalList":[{"MID":2,"sName":"交友族","Description":"关注他人达200人可获得，终身有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122316020555206722.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210252575158430.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"(点亮后30天有效)","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":3,"sName":"红人","Description":"粉丝人数达200人可获得，终身有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315513119670428.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210250753957944.png","IProgress":"0","DCoin":"50","DIntegral":"300","Effectivetime":"(点亮后30天有效)","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":4,"sName":"打赏族","Description":"近30天内，打赏他人达100城市币可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315504484486071.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210242085306376.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":5,"sName":"土豪","Description":"近30天内，向美女送礼物价值达300城市币可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315495651222363.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210233288215362.png","IProgress":"0","DCoin":"30","DIntegral":"200","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":7,"sName":"发帖狂","Description":"近30天内，发帖数量达20篇可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122316000931217859.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210225709654297.png","IProgress":"0","DCoin":"30","DIntegral":"200","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":8,"sName":"点赞控","Description":"近30天内，点赞照片、文章数达100个可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151224/2015122410383954945138.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210224011541926.png","IProgress":"0","DCoin":"10","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":10,"sName":"闹闹星","Description":"近30天内，在闹闹回复达50条可获得，点亮后30天有效","Image":"http://p5.pccoo.cn/vote/20160728/2016072818490700682566.png","HImage":"http://p5.pccoo.cn/vote/20160728/2016072818492177962998.png","IProgress":"0","DCoin":"30","DIntegral":"150","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":12,"sName":"沙发侠","Description":"近30天内，抢到沙发数达5次可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315481994799019.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210214185401722.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":13,"sName":"板凳侠","Description":"近30天内，抢到板凳数达5次可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315472655231527.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210152714907534.png","IProgress":"0","DCoin":"15","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":14,"sName":"马扎侠","Description":"近30天内，抢到马扎数达5次可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315461788239469.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210204410775834.png","IProgress":"0","DCoin":"10","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":15,"sName":"有态度","Description":"近30天内，对城事文章发表评论达20条可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315571631945525.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210202012280327.png","IProgress":"0","DCoin":"30","DIntegral":"150","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":17,"sName":"神评论","Description":"近30天内，对城事发表评论获得100以上点赞可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315561450888088.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210193515962413.png","IProgress":"0","DCoin":"50","DIntegral":"200","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":18,"sName":"分享使者","Description":"近30天内，分享数达20次可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151224/2015122410344467511294.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210191566698150.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":23,"sName":"封面女郎","Description":"终身勋章\u2014\u2014用户被管理员（编辑）在后台设为\u201c封面女郎\u201d后，将自动获得该勋章。并在其个人主页获得明显标识。","Image":"http://p3.pccoo.cn/vote/20151224/2015122410321418300660.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210184626303240.png","IProgress":"0","DCoin":"100","DIntegral":"300","Effectivetime":"(点亮后30天有效)","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":25,"sName":"封面萌宝","Description":"终身勋章\u2014\u2014用户被管理员（编辑）在后台设为\u201c封面萌宝\u201d后，将自动获得该勋章。并在其个人主页获得明显标识。","Image":"http://p3.pccoo.cn/vote/20151223/2015122315402541631467.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210183122847294.png","IProgress":"0","DCoin":"100","DIntegral":"300","Effectivetime":"(点亮后30天有效)","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":26,"sName":"榜上有名","Description":"近30天内，收到礼物价值达500城市币的美女可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315393667420807.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210175388401089.png","IProgress":"0","DCoin":"50","DIntegral":"200","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":28,"sName":"闹闹帝","Description":"近30天内，在闹闹发贴达20篇可获得，点亮后30天有效","Image":"http://p5.pccoo.cn/vote/20160728/2016072818474416121573.png","HImage":"http://p5.pccoo.cn/vote/20160728/2016072818480374160094.png","IProgress":"0","DCoin":"40","DIntegral":"200","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":29,"sName":"闹闹王","Description":"30天内获得回复50条可获得，点亮后30天有效","Image":"http://p5.pccoo.cn/vote/20160728/2016072818445484892062.png","HImage":"http://p5.pccoo.cn/vote/20160728/2016072818464479589028.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":30,"sName":"爱潜水","Description":"近30天内浏览次数达到100次可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151224/2015122410451968647127.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210164783658104.png","IProgress":"7","DCoin":"10","DIntegral":"30","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":60,"sName":"封面男神","Description":"终身勋章\u2014\u2014用户被管理员（编辑）在后台设为\u201c封面男神\u201d后，将自动获得该勋章。并在其个人主页获得明显标识。","Image":"http://p4.pccoo.cn/vote/20160509/2016050915445655735278.png","HImage":"http://p4.pccoo.cn/vote/20160509/2016050915444481798129.png","IProgress":"0","DCoin":"100","DIntegral":"300","Effectivetime":"(点亮后30天有效)","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":61,"sName":"捧场王","Description":"近30天内，在论坛评论达50条可获得，点亮后30天有效","Image":"http://p4.pccoo.cn/vote/20160509/2016050917065266756114.png","HImage":"http://p4.pccoo.cn/vote/20160509/2016050917062314988355.png","IProgress":"0","DCoin":"30","DIntegral":"150","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":62,"sName":"名人堂","Description":"30天内获得评论50条可获得，点亮后30天有效","Image":"http://p4.pccoo.cn/vote/20160509/2016050917081766543563.png","HImage":"http://p4.pccoo.cn/vote/20160509/2016050917075270311123.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"}],"Count":22}}
     * Extend : null
     * Count : 0
     * GxNum : 0
     * PageNum : 0
     * retime : 0.0175782
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
         * TUserMedalList : []
         * Count : 0
         */

        private TUserMedalListBean TUserMedalList;
        /**
         * TUserCanBeLitMedalList : []
         * Count : 0
         */

        private TUserCanBeLitMedalListBean TUserCanBeLitMedalList;
        /**
         * TMedalList : [{"MID":2,"sName":"交友族","Description":"关注他人达200人可获得，终身有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122316020555206722.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210252575158430.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"(点亮后30天有效)","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":3,"sName":"红人","Description":"粉丝人数达200人可获得，终身有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315513119670428.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210250753957944.png","IProgress":"0","DCoin":"50","DIntegral":"300","Effectivetime":"(点亮后30天有效)","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":4,"sName":"打赏族","Description":"近30天内，打赏他人达100城市币可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315504484486071.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210242085306376.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":5,"sName":"土豪","Description":"近30天内，向美女送礼物价值达300城市币可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315495651222363.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210233288215362.png","IProgress":"0","DCoin":"30","DIntegral":"200","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":7,"sName":"发帖狂","Description":"近30天内，发帖数量达20篇可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122316000931217859.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210225709654297.png","IProgress":"0","DCoin":"30","DIntegral":"200","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":8,"sName":"点赞控","Description":"近30天内，点赞照片、文章数达100个可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151224/2015122410383954945138.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210224011541926.png","IProgress":"0","DCoin":"10","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":10,"sName":"闹闹星","Description":"近30天内，在闹闹回复达50条可获得，点亮后30天有效","Image":"http://p5.pccoo.cn/vote/20160728/2016072818490700682566.png","HImage":"http://p5.pccoo.cn/vote/20160728/2016072818492177962998.png","IProgress":"0","DCoin":"30","DIntegral":"150","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":12,"sName":"沙发侠","Description":"近30天内，抢到沙发数达5次可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315481994799019.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210214185401722.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":13,"sName":"板凳侠","Description":"近30天内，抢到板凳数达5次可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315472655231527.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210152714907534.png","IProgress":"0","DCoin":"15","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":14,"sName":"马扎侠","Description":"近30天内，抢到马扎数达5次可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315461788239469.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210204410775834.png","IProgress":"0","DCoin":"10","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":15,"sName":"有态度","Description":"近30天内，对城事文章发表评论达20条可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315571631945525.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210202012280327.png","IProgress":"0","DCoin":"30","DIntegral":"150","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":17,"sName":"神评论","Description":"近30天内，对城事发表评论获得100以上点赞可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315561450888088.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210193515962413.png","IProgress":"0","DCoin":"50","DIntegral":"200","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":18,"sName":"分享使者","Description":"近30天内，分享数达20次可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151224/2015122410344467511294.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210191566698150.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":23,"sName":"封面女郎","Description":"终身勋章\u2014\u2014用户被管理员（编辑）在后台设为\u201c封面女郎\u201d后，将自动获得该勋章。并在其个人主页获得明显标识。","Image":"http://p3.pccoo.cn/vote/20151224/2015122410321418300660.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210184626303240.png","IProgress":"0","DCoin":"100","DIntegral":"300","Effectivetime":"(点亮后30天有效)","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":25,"sName":"封面萌宝","Description":"终身勋章\u2014\u2014用户被管理员（编辑）在后台设为\u201c封面萌宝\u201d后，将自动获得该勋章。并在其个人主页获得明显标识。","Image":"http://p3.pccoo.cn/vote/20151223/2015122315402541631467.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210183122847294.png","IProgress":"0","DCoin":"100","DIntegral":"300","Effectivetime":"(点亮后30天有效)","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":26,"sName":"榜上有名","Description":"近30天内，收到礼物价值达500城市币的美女可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151223/2015122315393667420807.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210175388401089.png","IProgress":"0","DCoin":"50","DIntegral":"200","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":28,"sName":"闹闹帝","Description":"近30天内，在闹闹发贴达20篇可获得，点亮后30天有效","Image":"http://p5.pccoo.cn/vote/20160728/2016072818474416121573.png","HImage":"http://p5.pccoo.cn/vote/20160728/2016072818480374160094.png","IProgress":"0","DCoin":"40","DIntegral":"200","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":29,"sName":"闹闹王","Description":"30天内获得回复50条可获得，点亮后30天有效","Image":"http://p5.pccoo.cn/vote/20160728/2016072818445484892062.png","HImage":"http://p5.pccoo.cn/vote/20160728/2016072818464479589028.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":30,"sName":"爱潜水","Description":"近30天内浏览次数达到100次可获得，点亮后30天有效","Image":"http://p3.pccoo.cn/vote/20151224/2015122410451968647127.png","HImage":"http://p3.pccoo.cn/vote/20160222/2016022210164783658104.png","IProgress":"7","DCoin":"10","DIntegral":"30","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":60,"sName":"封面男神","Description":"终身勋章\u2014\u2014用户被管理员（编辑）在后台设为\u201c封面男神\u201d后，将自动获得该勋章。并在其个人主页获得明显标识。","Image":"http://p4.pccoo.cn/vote/20160509/2016050915445655735278.png","HImage":"http://p4.pccoo.cn/vote/20160509/2016050915444481798129.png","IProgress":"0","DCoin":"100","DIntegral":"300","Effectivetime":"(点亮后30天有效)","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":61,"sName":"捧场王","Description":"近30天内，在论坛评论达50条可获得，点亮后30天有效","Image":"http://p4.pccoo.cn/vote/20160509/2016050917065266756114.png","HImage":"http://p4.pccoo.cn/vote/20160509/2016050917062314988355.png","IProgress":"0","DCoin":"30","DIntegral":"150","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"},{"MID":62,"sName":"名人堂","Description":"30天内获得评论50条可获得，点亮后30天有效","Image":"http://p4.pccoo.cn/vote/20160509/2016050917081766543563.png","HImage":"http://p4.pccoo.cn/vote/20160509/2016050917075270311123.png","IProgress":"0","DCoin":"20","DIntegral":"100","Effectivetime":"（点亮后30天有效）","MState":0,"IsAdvanced":0,"IsAdvancedStr":"1_100_100_200","CanBeLitCondition":"未点亮"}]
         * Count : 22
         */

        private TMedalListBean TMedalList;


        public TUserMedalListBean getTUserMedalList() {
            return TUserMedalList;
        }

        public void setTUserMedalList(TUserMedalListBean TUserMedalList) {
            this.TUserMedalList = TUserMedalList;
        }

        public TUserCanBeLitMedalListBean getTUserCanBeLitMedalList() {
            return TUserCanBeLitMedalList;
        }

        public void setTUserCanBeLitMedalList(TUserCanBeLitMedalListBean TUserCanBeLitMedalList) {
            this.TUserCanBeLitMedalList = TUserCanBeLitMedalList;
        }

        public TMedalListBean getTMedalList() {
            return TMedalList;
        }

        public void setTMedalList(TMedalListBean TMedalList) {
            this.TMedalList = TMedalList;
        }

        public static class TUserMedalListBean {
            private int Count;
            private List<?> TUserMedalList;


            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<?> getTUserMedalList() {
                return TUserMedalList;
            }

            public void setTUserMedalList(List<?> TUserMedalList) {
                this.TUserMedalList = TUserMedalList;
            }
        }

        public static class TUserCanBeLitMedalListBean {
            private int Count;
            private List<?> TUserCanBeLitMedalList;


            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<?> getTUserCanBeLitMedalList() {
                return TUserCanBeLitMedalList;
            }

            public void setTUserCanBeLitMedalList(List<?> TUserCanBeLitMedalList) {
                this.TUserCanBeLitMedalList = TUserCanBeLitMedalList;
            }
        }

        public static class TMedalListBean {
            private int Count;
            /**
             * MID : 2
             * sName : 交友族
             * Description : 关注他人达200人可获得，终身有效
             * Image : http://p3.pccoo.cn/vote/20151223/2015122316020555206722.png
             * HImage : http://p3.pccoo.cn/vote/20160222/2016022210252575158430.png
             * IProgress : 0
             * DCoin : 20
             * DIntegral : 100
             * Effectivetime : (点亮后30天有效)
             * MState : 0
             * IsAdvanced : 0
             * IsAdvancedStr : 1_100_100_200
             * CanBeLitCondition : 未点亮
             */

            private List<TMedalListBeans> TMedalList;


            public int getCount() {
                return Count;
            }

            public void setCount(int Count) {
                this.Count = Count;
            }

            public List<TMedalListBeans> getTMedalList() {
                return TMedalList;
            }

            public void setTMedalList(List<TMedalListBeans> TMedalList) {
                this.TMedalList = TMedalList;
            }

            public static class TMedalListBeans {
                private int MID;
                private String sName;
                private String Description;
                private String Image;
                private String HImage;
                private String IProgress;
                private String DCoin;
                private String DIntegral;
                private String Effectivetime;
                private int MState;
                private int IsAdvanced;
                private String IsAdvancedStr;
                private String CanBeLitCondition;


                public int getMID() {
                    return MID;
                }

                public void setMID(int MID) {
                    this.MID = MID;
                }

                public String getSName() {
                    return sName;
                }

                public void setSName(String sName) {
                    this.sName = sName;
                }

                public String getDescription() {
                    return Description;
                }

                public void setDescription(String Description) {
                    this.Description = Description;
                }

                public String getImage() {
                    return Image;
                }

                public void setImage(String Image) {
                    this.Image = Image;
                }

                public String getHImage() {
                    return HImage;
                }

                public void setHImage(String HImage) {
                    this.HImage = HImage;
                }

                public String getIProgress() {
                    return IProgress;
                }

                public void setIProgress(String IProgress) {
                    this.IProgress = IProgress;
                }

                public String getDCoin() {
                    return DCoin;
                }

                public void setDCoin(String DCoin) {
                    this.DCoin = DCoin;
                }

                public String getDIntegral() {
                    return DIntegral;
                }

                public void setDIntegral(String DIntegral) {
                    this.DIntegral = DIntegral;
                }

                public String getEffectivetime() {
                    return Effectivetime;
                }

                public void setEffectivetime(String Effectivetime) {
                    this.Effectivetime = Effectivetime;
                }

                public int getMState() {
                    return MState;
                }

                public void setMState(int MState) {
                    this.MState = MState;
                }

                public int getIsAdvanced() {
                    return IsAdvanced;
                }

                public void setIsAdvanced(int IsAdvanced) {
                    this.IsAdvanced = IsAdvanced;
                }

                public String getIsAdvancedStr() {
                    return IsAdvancedStr;
                }

                public void setIsAdvancedStr(String IsAdvancedStr) {
                    this.IsAdvancedStr = IsAdvancedStr;
                }

                public String getCanBeLitCondition() {
                    return CanBeLitCondition;
                }

                public void setCanBeLitCondition(String CanBeLitCondition) {
                    this.CanBeLitCondition = CanBeLitCondition;
                }
            }
        }
    }
}
