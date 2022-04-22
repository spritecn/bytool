## bytool 
>白兔  
>by2
>反正你怎么喜欢怎么叫，一个简单的工具包

## 工具包
- ArgsUtil
    - 用于方法多传参的一些校验 anyNull,getFistNotNull 之类的
- EquealsUtil
    - notEquals,allEquals
- BigDecimalUtil
    - 填了一下bigDecimal的判断类的，大于小于
- JSON
    - 对jackson的包装，用 fastjson的写法来用jackson
    - 大部分代码来自 https://github.com/zjb-it/jackson-replace-fastjson

## 食用
- gradel
```groovy
repositories {
    maven{ url 'https://spritecn.github.io/bytool/maven-repo/'}
}
dependencies {
    compile(
        'spritecn.github:bytool:1.0-SNAPSHOT',
    )
}
```
- maven不在中共仓，用起来蛮难的，
  - 参考这篇 https://zhuanlan.zhihu.com/p/141676033
  - 本来也是参考这篇推上去的
