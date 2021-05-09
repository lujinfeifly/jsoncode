package cn.miludeer.jsoncode.Test;

import java.io.File;

import org.junit.Test;

import cn.miludeer.jsoncode.fileformat.FileTemplate;
import cn.miludeer.jsoncode.fileformat.FileTemplate.Line;

/**
 * @author lujinfei
 * Created on 2021-05-07
 */
public class JsonCodeFileTest {

    @Test
    public void bb() {
        try {
//            Line line = new Line(1, "adddd {$.fggg} dsfvg {vvtgg()}sfvbgrbbtt  ");
//            Line line2 = new Line(1, " for {$.fggg} ");
//            Line line3 = new Line(1, "end ");

            String value = "{\"abc\": [{\"v\": 123, \"inner\": [{},{},{},{}]}, {\"v\": \"iop\",\"inner\": [{},{},{}]}]}";

            File file = new File("/Users/lujinfei/data/et.ff");
            FileTemplate template = new FileTemplate(file);

            String ret = template.parseResult(value);

            System.out.println("aaaaa: \n" + ret);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Test
    public void zhilian() {
        try{
            String json = "{\"age\":26,\"cityName\":\"四川-成都\",\"description\":null,\"education\":\"大专\",\"email\":\"\",\"evaluation\":\"抗压能力很强\",\"gender\":\"女\",\"imgUrl\":null,\"jobNumber\":\"CC264657880J40067692101\",\"jobResumeId\":530522731815,\"jobTitle\":\"质检专员\",\"jobTypeName\":\"前台文员\",\"lastCompanyName\":null,\"majorName\":\"其他\",\"phone\":\"\",\"resumeName\":\"审核员和统计员 \",\"resumeNumber\":\"yIdFrFGkCIIo(vUGtgTDBTH2MqC0Ifbo\",\"resumeSource\":1,\"schoolName\":\"新疆广播电视大学\",\"updateDate\":1620404224000,\"userName\":\"张雪莹\",\"workAge\":4}";

            File file = new File("/Users/lujinfei/data/zhilian.ff");
            FileTemplate template = new FileTemplate(file);

            String ret = template.parseResult(json);

            System.out.println("aaaaa: \n" + ret);

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void liepin() {
        try{
            String json = "{   \"res_name\":\"涂磊\",   \"res_email\":\"171550205@qq.com\",   \"res_tel\":\"18113097668\",   \"refresh_time\":\"20210508161731\",   \"res_company\":\"融创西南区域（城市公司）\",   \"user_id\":65750219,   \"res_sex_name\":\"男\",   \"res_birth_year_age\":29,\"res_edulevel_name\":\"本科\",\"res_dq\":\"280020\",   \"res_dq_name\":\"成都\",   \"res_title\":\"财务经理\",   \"res_format\":\"1\",   \"res_selfassess\":\"首先，本人在融创西南房地产开发(集团)重庆财务管理部担任两个房地产项目的项目财务经理，全面协调和处理项目所有与财务相关事项，涵盖拿地测算、营销定价、成本优化、税务筹划、资金安排、融资保理等，拥有全流程项目经验，自己对工作及细节把控较为严格。\u2028其次，本人在国内八大内资所之一的大信所从事审计工作6年，具备丰富的审计、财务管理经验，曾多次担任上市公司、新三板、大中型企业审计的项目经理，同时也参与多家公司的收并购审计和财务尽职调查，涉及的行业也较为广泛，能快速适应公司多元化的工作安排，另擅长财务分析，具备较强的文字综合表达能力。\u2028在工作之余通过项目经验以及学习取得了CPA证书、法律从业资格证书、证券及基金类从业资格证书，能以较为全面的知识和经验应对工作中遇到的问题。\u2028最后，本人较为踏实稳重，对事情响应积极，遇到问题快速与各部门沟通协调，以便保质保量解决。\",   \"res_wantdq_name\":\"成都\",   \"res_wantjobtitle_name\":\"财务经理/主管,审计管理,投后管理岗\",   \"res_sex\":\"男\",   \"res_birth_year\":1991,   \"res_id\":82041381,   \"languageDto\":{       \"res_flag\":\"1001000000\",       \"res_language_name\":\"英语、普通话\",       \"res_language_english\":1,       \"res_language_japanese\":0,       \"res_language_french\":0,       \"res_language_putong\":1,       \"res_language_yueyu\":0,       \"res_language_other\":0   },   \"res_edulevel\":\"040\",   \"res_hope\":\"1\",   \"res_industry_name\":\"房产开发\",   \"res_jobtitle_name\":\"财务经理/主管\",   \"res_wantindustry\":\"1840\",   \"res_wantindustry_name\":\"房产开发\",   \"res_wantdq\":\"280020\",   \"res_wantjobtitle\":\"N000347,N000357,N000435\",   \"res_langkind\":\"0\",   \"res_edulevel_tz\":\"1\",   \"res_industry\":\"1840\",   \"res_jobtitle\":\"N000347\",   \"completeDegree\":100,   \"workExpDtoList\":[       {           \"res_id\":82041381,           \"start_year\":\"2020\",           \"start_month\":\"09\",           \"end_year\":\"2020\",           \"end_month\":\"12\",           \"rwd_id\":53808665,           \"rwd_start\":\"202009\",           \"rwd_end\":\"202012\",           \"rwd_compname\":\"融创西南区域（城市公司）\",           \"rwd_compdesc\":\"\",           \"rwd_compkind\":\"\",           \"rwd_compscale\":\"\",           \"rwd_industry\":\"1840\",           \"rwd_compkind_name\":\"\",           \"rwd_compscale_name\":\"\",           \"rwd_industry_name\":\"房产开发\",           \"workExpSegDto\":[               {                   \"res_id\":82041381,                   \"start_year\":\"2020\",                   \"start_month\":\"09\",                   \"end_year\":\"2020\",                   \"end_month\":\"12\",                   \"rwds_salmonths\":16,                   \"rwd_id\":53808665,                   \"rwds_id\":0,                   \"rwds_start\":\"202009\",                   \"rwds_end\":\"202012\",                   \"rwds_dq_name\":\"成都\",                   \"rwds_title\":\"财务经理\",                   \"rwds_salary\":\"21000\",                   \"rwds_dq\":\"280020\",                   \"rwds_dept\":\"财务管理部\",                   \"rwds_report2\":\"财务总监\",                   \"rwds_subordinate\":\"8\",                   \"rwds_duty\":\"手上目前负责两个开发项目，分别为镜山月项目、山晓项目\u2028具体工作如下：\u20281、全面负责项目的整体财务管理事项；\u20282、负责项目经营计划的编制、指标测算、付款沟通、执行跟踪、分析；\u20283、负责项目日常税务事项的处理以及税务目标的达成；\u20284、项目预售、项目收并购及股权合作、收银、按揭、资金、预算、税务、财务共享等事项协调；\u20285、根据国内会计准则及香港会计准则财务报表编制汇总及调整\",                   \"rwds_achievement\":\"手上目前负责两个开发项目，分别为镜山月项目、山晓项目\u2028具体工作如下：\u20281、全面负责项目的整体财务管理事项；\u20282、负责项目经营计划的编制、指标测算、付款沟通、执行跟踪、分析；\u20283、负责项目日常税务事项的处理以及税务目标的达成；\u20284、项目预售、项目收并购及股权合作、收银、按揭、资金、预算、税务、财务共享等事项协调；\u20285、根据国内会计准则及香港会计准则财务报表编制汇总及调整\"               }           ]       },       {           \"res_id\":82041381,           \"start_year\":\"2015\",           \"start_month\":\"07\",           \"end_year\":\"2020\",           \"end_month\":\"08\",           \"rwd_id\":53808667,           \"rwd_start\":\"201507\",           \"rwd_end\":\"202008\",           \"rwd_compname\":\"大信会计师事务所(特殊普通合伙)四川分所\",           \"rwd_compdesc\":\"\",           \"rwd_compkind\":\"030\",           \"rwd_compscale\":\"050\",           \"rwd_industry\":\"430\",           \"rwd_compkind_name\":\"私营·民营企业\",           \"rwd_compscale_name\":\"1000-2000人\",           \"rwd_industry_name\":\"会计/审计\",           \"workExpSegDto\":[               {                   \"res_id\":82041381,                   \"start_year\":\"2015\",                   \"start_month\":\"07\",                   \"end_year\":\"2020\",                   \"end_month\":\"08\",                   \"rwds_salmonths\":15,                   \"rwd_id\":53808667,                   \"rwds_id\":0,                   \"rwds_start\":\"201507\",                   \"rwds_end\":\"202008\",                   \"rwds_dq_name\":\"成都-高新区\",                   \"rwds_title\":\"审计项目经理\",                   \"rwds_salary\":\"18000\",                   \"rwds_dq\":\"280020170\",                   \"rwds_dept\":\"\",                   \"rwds_report2\":\"\",                   \"rwds_subordinate\":\"\",                   \"rwds_duty\":\"1、带领现场团队完成上市公司、新三板等企业审计、鉴证业务；\u20282、财务尽职调查、IPO、收并购、财务咨询等工作；\u20283、管理协调项目小组的工作，审计进度和质量的管理、对项目团队人员进行工作指导、监督和评估；\u20284、协助出具审计业务报告和其他法定\",                   \"rwds_achievement\":\"1、带领现场团队完成上市公司、新三板等企业审计、鉴证业务；\u20282、财务尽职调查、IPO、收并购、财务咨询等工作；\u20283、管理协调项目小组的工作，审计进度和质量的管理、对项目团队人员进行工作指导、监督和评估；\u20284、协助出具审计业务报告和其他法定\"               }           ]       },       {           \"res_id\":82041381,           \"start_year\":\"2014\",           \"start_month\":\"06\",           \"end_year\":\"2015\",           \"end_month\":\"07\",           \"rwd_id\":53761679,           \"rwd_start\":\"201406\",           \"rwd_end\":\"201507\",           \"rwd_compname\":\"四川普林会计师事务所有限公司\",           \"rwd_compdesc\":\"\",           \"rwd_compkind\":\"\",           \"rwd_compscale\":\"\",           \"rwd_industry\":\"430\",           \"rwd_compkind_name\":\"\",           \"rwd_compscale_name\":\"\",           \"rwd_industry_name\":\"会计/审计\",           \"workExpSegDto\":[               {                   \"res_id\":82041381,                   \"start_year\":\"2014\",                   \"start_month\":\"06\",                   \"end_year\":\"2015\",                   \"end_month\":\"07\",                   \"rwds_salmonths\":12,                   \"rwd_id\":53761679,                   \"rwds_id\":0,                   \"rwds_start\":\"201406\",                   \"rwds_end\":\"201507\",                   \"rwds_dq_name\":\"成都-武侯区\",                   \"rwds_title\":\"审计员\",                   \"rwds_salary\":\"\",                   \"rwds_dq\":\"280020020\",                   \"rwds_dept\":\"\",                   \"rwds_report2\":\"\",                   \"rwds_subordinate\":\"\",                   \"rwds_duty\":\"主要参与中型企业财务审计、税务审计、土地增值税清算、所得税清算、工程审计、财务竣工决算审计、财税筹划等鉴证报告的出具。\",                   \"rwds_achievement\":\"主要参与中型企业财务审计、税务审计、土地增值税清算、所得税清算、工程审计、财务竣工决算审计、财税筹划等鉴证报告的出具。\"               }           ]       }   ],   \"eduExpDtoList\":[       {           \"createtime\":\"20200713201529\",           \"res_id\":82041381,           \"start_year\":\"2011\",           \"start_month\":\"09\",           \"end_year\":\"2014\",           \"end_month\":\"06\",           \"delflag\":\"0\",           \"red_special\":\"金融学（第二专业）\",           \"red_id\":30375049,           \"red_start\":\"201109\",           \"red_end\":\"201406\",           \"red_school\":\"北京师范大学珠海分校\",           \"red_degree\":\"040\",           \"red_tz\":\"1\",           \"red_degree_name\":\"本科\",           \"red_tz_name\":\"是\",           \"red_type\":\"\",           \"red_kind\":\"\",           \"red_gpa\":0       },       {           \"createtime\":\"20190926155754\",           \"res_id\":82041381,           \"start_year\":\"2010\",           \"start_month\":\"09\",           \"end_year\":\"2014\",           \"end_month\":\"06\",           \"delflag\":\"0\",           \"red_special\":\"物流工程（第一专业）\",           \"red_id\":30204819,           \"red_start\":\"201009\",           \"red_end\":\"201406\",           \"red_school\":\"北京师范大学珠海分校\",           \"red_degree\":\"040\",           \"red_tz\":\"1\",           \"red_degree_name\":\"本科\",           \"red_tz_name\":\"是\",           \"red_type\":\"\",           \"red_kind\":\"\",           \"red_gpa\":0       }   ],   \"projectExpDtoList\":[       {           \"createtime\":\"20201216135257\",           \"res_id\":82041381,           \"start_year\":\"2020\",           \"start_month\":\"09\",           \"end_year\":\"2020\",           \"end_month\":\"12\",           \"rpd_id\":20303949,           \"rpd_name\":\"镜山月项目\",           \"rpd_start\":\"202009\",           \"rpd_end\":\"202012\",           \"rpd_title\":\"项目财务经理\",           \"rpd_desc\":\"项目名称：融创镜山月项目\u2028开发单位：融创西南房地产开发（集团）有限公司\u2028占地面积：目前财务正在协同研判测算1000亩拿地规模的经济效益\u2028已拿地首开住宅占地172亩，商业38亩\u2028设计面积：住宅12.6万平米，商业1.3万平米\u2028容积率：住宅1.08 商业 0.53\",           \"rpd_duty\":\"具体工作如下：\u20281、全面负责项目的整体财务管理事项；\u20282、负责项目经营计划的编制、指标测算、付款沟通、执行跟踪、分析；\u20283、负责项目日常税务事项的处理以及税务目标的达成；\u20284、项目预售、项目收并购及股权合作、收银、按揭、资金、预算、税务、财务共享等事项协调；\u20285、国内会计准则及香港会计准则财务报表填报及调整\",           \"rpd_achievement\":\"\",           \"rpd_compname\":\"融创西南房地产开发(集团)有限公司\"       },       {           \"createtime\":\"20201216135044\",           \"res_id\":82041381,           \"start_year\":\"2020\",           \"start_month\":\"09\",           \"end_year\":\"2020\",           \"end_month\":\"12\",           \"rpd_id\":20303947,           \"rpd_name\":\"山晓项目\",           \"rpd_start\":\"202009\",           \"rpd_end\":\"202012\",           \"rpd_title\":\"项目财务经理\",           \"rpd_desc\":\"重庆南山山晓项目为厦门联发集团与融创的合作项目，融创占股20%，由于融创操盘经验丰富，因此融创主导营销、成本、工程、财务等重要职责的相关工作，项目总也由融创派任。\u2028主要产品业态为叠拼、合院、独立商业、洋房，可售面积 124,569平方米。\",           \"rpd_duty\":\"具体工作如下：\u20281、全面负责项目的整体财务管理事项；\u20282、负责项目经营计划的编制、指标测算、付款沟通、执行跟踪、分析；\u20283、负责项目日常税务事项的处理以及税务目标的达成；\u20284、项目预售、项目收并购及股权合作、收银、按揭、资金、预算、税务、财务共享等事项协调；\u20285、国内会计准则及香港会计准则财务报表填报及调整\",           \"rpd_achievement\":\"\",           \"rpd_compname\":\"融创西南房地产开发(集团)有限公司\"       },       {           \"createtime\":\"20201216140029\",           \"res_id\":82041381,           \"start_year\":\"2015\",           \"start_month\":\"11\",           \"end_year\":\"2020\",           \"end_month\":\"08\",           \"rpd_id\":20303963,           \"rpd_name\":\"主要参与审计项目列举\",           \"rpd_start\":\"201511\",           \"rpd_end\":\"202008\",           \"rpd_title\":\"项目经理\",           \"rpd_desc\":\"主要参与项目如下：\u2028成都市新筑路桥机械股份有限公司（上市）审计\u2028西藏银河科技发展股份有限公司（上市）审计\u2028德阳天元重工股份有限公司（拟IPO）审计辅导\u2028华塑控股股份有限公司（上市）审计\u2028四川广润投资基金收并购财务尽职调查\u2028四川产业振兴发展投资基金收并购股财务尽职调查\u2028欢乐盛典演艺公司收并购财务尽职调查\u2028四川知行路桥股份有限公司（新三板）审计\u2028上海赛立特安全用品有限公司（新三板）审计\u2028柯美特建材集团股份有限公司（新三板）审计\u2028中国农业银行四川省分行大楼财务竣工决算审核\u2028中信国安建工集团有限公司审计\u2028四川省晟茂建设集团有限公司审计\u2028四川天之汇建筑工程有限公司审计\u2028通江县力迅交投建设有限公司审计\u2028自贡天成工程机械有限公司审计\",           \"rpd_duty\":\"作为审计负责人担任项目经理\",           \"rpd_achievement\":\"\",           \"rpd_compname\":\"\"       },       {           \"createtime\":\"20201216135448\",           \"res_id\":82041381,           \"start_year\":\"2016\",           \"start_month\":\"11\",           \"end_year\":\"2020\",           \"end_month\":\"04\",           \"rpd_id\":20303951,           \"rpd_name\":\"新筑路桥（深交所上市）年报、并购重组审计\",           \"rpd_start\":\"201611\",           \"rpd_end\":\"202004\",           \"rpd_title\":\"项目经理\",           \"rpd_desc\":\"成都市新筑路桥机械股份有限公司是一家在深交所上市的企业，主要从事轨道交通、桥梁功能部件、超能电池制造等业务。具备地铁车辆、现代有轨电车研发制造和维修能力，目前成都地铁3/4/5/9等地铁车辆均该企业提供。我所项目团队即担任新筑股份的年报、并购重组审计业务及其他财税咨询服务。\",           \"rpd_duty\":\"1、与企业各部门负责人、财务总监沟通审计关键、重要事项\u20282、做好审计计划、协调项目组成员的工作安排，把控审计工作质量和进度\u20283、做好内控测试，识别的重大错报风险与初步的应对措施\u20284、独立负责上市企业重要子公司（长客新筑轨道、桥梁构件）审计\u20285、完成母公司销售与收款、采购与成本业务循环、研发项目的审计\u20286、对项目助理工作提供督导，完成对底稿的内部复核程序\",           \"rpd_achievement\":\"我所大约派出10人团队对该上市企业进行审计，协助合伙人完满的完成了2016年-2019年这三年的年报审计工作，2018/2019年作为承上启下的负责人在项目管理上不仅熟练掌握了管理团队、指导团队、解决重大疑难问题，在审计过程中针对客户内部控制缺陷提出管理建议及为客户设计各种财税规划、并购方案。\",           \"rpd_compname\":\"成都市新筑路桥机械股份有限公司（上市公司）\"       },       {           \"createtime\":\"20201216135655\",           \"res_id\":82041381,           \"start_year\":\"2016\",           \"start_month\":\"12\",           \"end_year\":\"2020\",           \"end_month\":\"03\",           \"rpd_id\":20303959,           \"rpd_name\":\"德阳天元重工股份有限公司年报、并购重组常年审计（IPO审计）\",           \"rpd_start\":\"201612\",           \"rpd_end\":\"202003\",           \"rpd_title\":\"项目经理\",           \"rpd_desc\":\"德阳天元重工股份有限公司是一家在全国股转系统（新三板创新层）上市的企业，目前拟IPO，是一家悬索桥索鞍、索夹等核心受力部件的制造企业,并且拥有索夹铸造基地，企业的业务在该细分领域数一数二。\u2028而我所任职的会计师事务所即担任天元重工的年报、并购重组审计、IPO辅导业务及其他财税服务的审计机构。\",           \"rpd_duty\":\"1、与企业各部门负责人、财务总监沟通审计关键、重要事项\u20282、做好审计计划、协调项目组成员的工作安排，把控找工作质量和进度\u20283、做好内控测试，识别的重大错报风险与初步的应对措施\u20284、负责企业重要子公司（兴天元钢桥、安立通）审计\u20285、完成集团公司重要科目的审计\u20286、对项目助理工作提供督导，完成对底稿的内部复核程序\",           \"rpd_achievement\":\"带领的5人团队对该企业进行审计，经规范辅导，已逐渐符合上市标准，同时也已圆满的完成了2017年-2019年这两年的年报审计工作，较为熟练的掌握财务管理、业务辅导的关键点。\",           \"rpd_compname\":\"德阳天元重工股份有限公司（创新层企业、目前拟IPO）\"       },       {           \"createtime\":\"20201216135857\",           \"res_id\":82041381,           \"start_year\":\"2017\",           \"start_month\":\"11\",           \"end_year\":\"2019\",           \"end_month\":\"11\",           \"rpd_id\":20303961,           \"rpd_name\":\"西藏发展（深交所上市）年报、并购重组审计\",           \"rpd_start\":\"201711\",           \"rpd_end\":\"201911\",           \"rpd_title\":\"项目经理\",           \"rpd_desc\":\"西藏银河科技发展股份有限公司是是一家在深交所上市的企业，主要从事啤酒生产、投资管理等业务，我所项目团队即担任西藏发展的年报、并购重组审计业务及其他财税服务。\",           \"rpd_duty\":\"1、与企业各部门负责人、财务总监沟通审计关键、重要事项\u20282、做好审计计划、协调项目组成员的工作安排，把控工作质量和进度\u20283、做好内控测试，识别的重大错报风险与初步的应对措施\u20284、负责上市企业重要子公司（拉萨啤酒、恒生高尔夫）审计\u20285、完成母公司销售与收款、采购与成本业务循环、货币资金项目的审计\u20286、对项目助理工作提供督导，完成对底稿的内部复核程序\",           \"rpd_achievement\":\"我所大约派出10人团队对该上市企业进行审计，西藏发展目前由于对控股股东违规担保问题处于*ST状态，审计难度较大，最终圆满的完成了2017年-2019年这两年的年报审计工作。\",           \"rpd_compname\":\"西藏银河科技发展股份有限公司（上市公司）\"       }   ],   \"res_addition\":\"已取得注册会计师证书、法律职业资格证书、证券、基金相关从业证书。\",   \"res_school_kind\":\"0\",   \"c_name_show\":\"涂先生\",   \"res_nowsalary\":21000,   \"res_salmonths\":16,   \"res_marriage\":\"9\",   \"res_workyear\":2014,   \"res_caption\":\"中文简历_20191226\",   \"res_edulevel_tz_name\":\"是\",   \"res_hope_name\":\"离职，正在找工作\",   \"res_workyear_age\":6,   \"res_marriage_name\":\"保密\",   \"res_wantsalary\":22000,   \"res_want_salmonths\":15,   \"res_langkind_name\":\"中文\"}";

            File file = new File("/Users/lujinfei/data/liepin.ff");
            FileTemplate template = new FileTemplate(file);

            String ret = template.parseResult(json);

            System.out.println("aaaaa: \n" + ret);

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void maimai() {
        try{
            String json = "{           \"stags\":\"\",           \"avatar\":\"https://i9.taou.com/maimai/p/20790/7990_126_2CknG4UBA49OiQ-a160\",           \"username\":\"陈洁丽\",           \"realname\":\"陈洁丽\",           \"mobile\":\"18680058275\",           \"email\":\"\",           \"gender\":2,           \"degree\":0,           \"company\":\"前锦网络信息技术(上海)有限公司东莞分公司\",           \"position\":\"区域经理\",           \"province\":\"广东\",           \"city\":\"东莞\",           \"profession\":\"IT互联网\",           \"major\":\"销售\",           \"salary\":\"未知\",           \"work_time\":\"5-10年\",           \"work_time_idx\":3,           \"edu_exp\":[               {                   \"id\":40072707,                   \"cur\":0,                   \"school\":\"北京语言大学\",                   \"department\":\"人力资源管理\",                   \"degree\":\"专科\",                   \"description\":\"\",                   \"sid\":446,                   \"status\":1,                   \"mj_code\":\"\",                   \"judge\":0,                   \"start_date\":\"2015-1\",                   \"end_date\":\"2018-1\",                   \"start_month\":1,                   \"end_month\":1,                   \"start\":2015,                   \"end\":2018,                   \"tags\":[                   ]               }           ],           \"work_exp\":[               {                   \"id\":39082483,                   \"cur\":1,                   \"company\":\"前锦网络信息技术(上海)有限公司东莞分公司\",                   \"sus_company\":null,                   \"position\":\"区域经理\",                   \"sus_position\":\"\",                   \"department\":\"招聘业务部\",                   \"sus_department\":\"\",                   \"description\":\"负责的业务：团队销售管理\u2028擅长的技能：日常团队目标管理，沟通协调内外部事宜。\u2028\",                   \"sus_description\":\"\",                   \"cid\":0,                   \"freelance\":0,                   \"status\":1,                   \"pf_path\":\"01\",                   \"mj_code\":\"0103\",                   \"sub_mj_code\":\"010308\",                   \"sub_mj_name\":\"市场销售\",                   \"judge\":1,                   \"start_date\":\"2012-8\",                   \"start_month\":8,                   \"start\":2012,                   \"tags\":[                       \"沟通协调能力\",                       \"产品销售\",                       \"执行力\",                       \"团队精神\",                       \"抗压能力\",                       \"解决方案销售\",                       \"大客户销售\"                   ],                   \"company_info\":{                   },                   \"profession2\":[                       [                           {                               \"code\":\"01\",                               \"name\":\"IT/互联网\",                               \"level\":1,                               \"explanation\":\"互联网|IT|游戏|软件\"                           }                       ]                   ],                   \"major2\":[                       [                           {                               \"code\":\"0103\",                               \"name\":\"销售\",                               \"level\":1                           }                       ]                   ],                   \"end\":0,                   \"end_date\":\"\"               }           ],           \"apply_time\":\"2021-05-08 16:30:23\",           \"resume_uid\":539059739,           \"jid\":805437329,           \"open_data\":\"4402E0000\"       }";

            File file = new File("/Users/lujinfei/data/maimai.ff");
            FileTemplate template = new FileTemplate(file);

            String ret = template.parseResult(json);

            System.out.println("aaaaa: \n" + ret);

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
