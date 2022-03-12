### InvalidDefinitionException 无效定义异常

No serializer found for class com.xxx and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain: java.util.ArrayList[0])



原因：无法找到对应类的字段

解决：创建未找到对应类的字段和get/set方法

一般在对象转换json字符串的时候会出现这种问题。

