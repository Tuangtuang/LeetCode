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
Arrays.copyOfRange(nums, start, end);

Arrays.binarySearch(nums,target);
```

### 转list

```java
return new ArrayList<Integer>(Arrays.asList(res));
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

- 转arrays

  ```java
  List<String> res=new ArrayList<>();
  res.toArray(new String[res.size()]);
  ```

  

## StringBuilder

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

## ArrayDeque

- addFirst()
- addLast()

## Collections

- sort

  - ```java
    List<User> list = new ArrayList<>();
    list.add(new User("张三",18));
    list.add(new User("诸葛亮",69));
    list.add(new User("孙悟空",500));
    list.add(new User("周杰伦",45));
    list.add(new User("郭德纲",60));
    list.add(new User("秦始皇",5000));
    Collections.sort(list, new Comparator<User>() {
                
                @Override
                public int compare(User o1, User o2) {
                    int age1 = o1.getAge();
                    int age2 = o2.getAge();
                    if (age1 == age2) {
                        return 0;
                    }else {
                        // 从小到大
                        return age1 > age2 ? 1 : -1 ;
                        // 如果需要从大到小，可以将return的值反过来即可
                    }
                }
                
    });
    ```

  - 当compare的返回值小于0时，会将 t2 和 t1 （compare()中的两个参数）交换顺序，大于等于0不会变换顺序；

  - 如果你想升序，那么o1比o2小就是我想要的；所以返回-1，类比成false；表示我不想调整顺序 

  - 如果你想降序，那么o1比o2小不是我想要的；所以返回1，类比成true；表示我想调整顺序

  - my sample

    - ```java
      // 354. Russian Doll Envelopes
      public int maxEnvelopes(int[][] envelopes) {
              if(envelopes.length==0){
                  return 0;
              }
              Arrays.sort(envelopes, new Comparator<int []>(){
                  @Override
                  public int compare(int [] a, int []b){
                      if(a[0]==b[0]){
      //                     descending
                          return a[1]<b[1]?1:-1;
                      } else{
      //                     ascendeing
                          return a[0]<b[0]?-1:1;
                      }
                  }
              });
              int []dp=new int [envelopes.length];
              Arrays.fill(dp,1);
              int max=dp[0];
              for(int i=1;i<dp.length;i++){
                  int j=i-1;
                  while(j>=0){
                      if(envelopes[j][1]<envelopes[i][1]){
                          dp[i]=Integer.max(dp[i],dp[j]+1);
                          if(dp[i]>max){
                              max=dp[i];
                          }
                      }
                      j--;
                  }
              }
              return max;
          }
      ```


# PriorityQueue

- ```java
  PriorityQueue<Integer> q=new PriorityQueue<>();
  q.add(1);
  q.poll()
  ```

# Map

## 数据操作

```java
Map<Integer, Integer> m = new HashMap<>();
m.containsKey(key);
m.containsValue(value);
m.put(key,value);
m.get(key);
m.remove(key);
m.remove(key,value);
```

## 遍历

```java
Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
//遍历map中的键 
for (Integer key : map.keySet()) { 
  System.out.println("Key = " + key); 
} 
//遍历map中的值 
for (Integer value : map.values()) { 
  System.out.println("Value = " + value); 
}

//遍历map中的key-value
Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
for (Map.Entry<Integer, Integer> entry : map.entrySet()) { 
  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
}
```

## getOrDefault()方法的使用

1. getOrDefault(key,default)
   作用：如果存在相应的key则返回其对应的value，否则返回给定的默认值。
2. key的值相同，使value的值加一。比如需要统计一个字符串中所含的字母及对应字母的个数。
   方法：
   （1）定义一个哈希表hash
   （2）hash.put(c,hash.getOrDefault(c,0)+1); //若没有就是0，若有就是原有值增一。

# String and char[]

## String to char[]

```java
String s="test";
char []str=s.toCharArray();
```

## char [] to String

```java
char []str=new str[10];
String s=String.valueOf(str);
```

