
## 为什么要做jsoncode

在json的处理世界中我们常见的使用包有几个，其中大家用的fastjson号称性能最高的一款。但是我们在拿到一个json字符串后，
发现如果使用fastjson进行解析会需要定义若干的class进行匹配，在json中如果仅需要获取其中一个字段，或若干层后的某个字段的时候
需要做的工作就会更多。这个时候我们的需求就是简单的获取其中的一个值咋办，我们可以看看下面的例子。


## 我们的例子

json字符串：
```
{"ss":{"sss":"vvvvv","city":{"name":"上海","list":["1","eeee","33vsvg"]}}}
```
如果我们在实际使用中仅使用这个字符串中的城市名字的字段，其他都不需要，我们应该怎么处理。
我们的方式是这样的：
```
String code = JsonCode.getValue(json,"$.ss.city.name");
```
这个时候code的值就是上海。我们仅通过一条语句就可以实现我们要获取的内容。

## 什么时候不建议用

当json中的所有字段都需要使用的时候，就不建议使用此方式。


## 包的使用（MAVEN）
```
<dependency>
  <groupId>cn.miludeer</groupId>
  <artifactId>jsoncode</artifactId>
  <version>1.1</version>
</dependency>
```
## 全部功能列表

#### 1. 基本值获取
```
// 取得json某个值，入参为目标json，路径值（以$开头），返回值为值的String表示
String code = JsonCode.getValue(json,"$.ss.city.name");
```

#### 2. 返回列表
```
// 取得json某个值代表的list列表，入参为目标json，路径值（以$开头），返回值为值的String数组
// 如果目标值不是json格式的列表([]包围)，则返回null
String[] code = JsonCode.getValueList(json,"$.ss.fg.list");
```

#### 3. 表达式计算

表达式计算为前面的单个值获取的更多的可能方式，我们提供下面这些表达方式这些表达式方法：

值的计算：+ - * /   计算全部已整数表达，不提供小数的方式。
值的比较：> < =     结果为true或false的字符串表示。 <  > 比较值必须为数字
布尔运算：& |       运算值必须为布尔的string表示。

几个函数：
1. listsize(var1)              计算list的大小。
2. listfind(var1, var2, var3)  查找var1的列表中key为var2时值为var3的json串，若多个取第一个。
3. listget(var1, var2)         取得list中第var2-1的元素。

举例：
```
// json = {"ss":{"sss":"vvvvv","fg":{"f":"ererer","list":[{"dfv":8,"tg":"sfvgbggb"}, {"rrr":3}]}}}
用以下表达式计算：
String ret = JsonCode.calExpressionResult(json,"listsize($.ss.fg.list) + 9");

// listsize($.ss.fg.list) + 9           结果为： 11
// listget($.ss.fg.list , 1)            结果为： {"rrr":3}
// listfind($.ss.fg.list , dfv, 3).tg   结果为： sfvgbggb
```