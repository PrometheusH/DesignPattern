# Builder 生成器模式
Builder负责提供所有的步骤方法，这些步骤方法都是生产自己持有产品的过程，但它不知道这些方法的执行顺序，Director负责将这些方法按规定的顺序运行与处理，最后客户端需要Builder中的产品。

# 代码解析

## old
- ExportHeaderModel类：文件头的数据模型
- ExportBodyModel类：文件体的数据模型
- ExportFooterModel类：文件尾的数据模型
- ExportToTxt类：将以上数据拼接输出到txt文件
- ExportToXml类：将以上数据拼接成Xml文件输出

>存在问题：当增加新的输出模式时，需要新的输出类。   
>对于这些输出类，处理过程是相同的：  
>1. 先拼接文件头的内容
>2. 然后拼接文件体的内容
>3. 再拼接文件尾的内容
>4. 把拼接好的内容输出出去形成文件
>
>如何做到处理过程不变，每个步骤的具体处理方式可以定制
>
## model

- Product接口：定义Bulider要生产的产品
- Builder接口：定义生产产品的一些步骤（方法）
- ConcreteBuilder类：实现Builder接口
- Director类：定义Builder中这些步骤的顺序等

## concrete















