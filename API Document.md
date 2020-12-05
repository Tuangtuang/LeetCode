# API Document

## Basic

### 强制类型转化

```java
int i=0;
char c = (char) i;
```

- int to char 会是去精确度，需要强制(char)

## Arrays

### Copy

```java
Arrays.copyOfRange(nums, start, end)
```

## List

### LinkedList

- 没有removeLast方法

- remove

- ```java
  List<Integer> arr = new LinkedList<>();
  arr.remove(index)
  ```

### ArrayList

- 没有removeLast方法

## String Builder

- Detete

  - ```java
    StringBuilder s=new StringBuilder();
    s.delete(int start, int end);
    s.deleteCharAt(int index);
    ```

- substring(start,end)

  - ```java
    StringBuilder s = new StringBuilder("haha");
    String temp=s.substring(0,1);
    System.out.println(temp);//h
    System.out.println(s.toString());//haha
    ```

    