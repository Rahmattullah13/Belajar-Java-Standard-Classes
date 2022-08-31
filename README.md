# Java Standard Classes

## String Class

- String di Java adalah object, artinya dia memiliki representasi class nya.
- Ada banyak sekali method yang bisa kita gunakan di String, kita bisa melihat detail method apa saja yang tersedia
di halaman dokumentasi [javadoc nya](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/String.html).

**Contoh method yang tersedia di String Class:**

| Method                    | Keterangan                                    |
|:--------------------------|:----------------------------------------------|
| String toLowerCase()      | Membuat string baru dengan format lower case. |
| String toUpperCase()      | Membuat string baru dengan format upper case. |
| int length()              | Mendapatkan panjang dari string.              |
| boolean startsWith(value) | Mengecek apakah dimulai dengan string value   |
| boolean endsWith(value)   | Mengecek apakah diakhiri dengan string value  |
| String[] split(value)     | Memotong string dengan string value.          |

**Contoh penggunaannya:** 

```java
public class StringApp {
    public static void main(String[] args) {
        
        String name = "Rifki Rahmattullah";
        String nameLowercase = name.toLowerCase();
        String nameUppercase = name.toUpperCase();

        System.out.println(name);
        System.out.println(nameLowercase);
        System.out.println(nameUppercase);
        System.out.println(name.length());
        System.out.println(name.startsWith("Rifki"));
        System.out.println(name.endsWith("Rahmattullah"));
        
        String[] names = name.split(" ");
        for (var value : names) {
            System.out.println(value);
        }
    }
}
```

## StringBuffer dan StringBuilder

### Immutable String

- String adalah tipe data immutable, artinya tidak bisa diubah isinya, saat kita mengubah string, 
sebenarnya yang dilakukan di java adalah membuat String baru.
- Jika kita ingin memanipulasi String dalam jumlah banyak, sangat tidak disarankan menggunakan String, 
karena akan memakan yang cukup besar, untuk kasus seperti ini disarankan untuk menggunakan StringBuffer atau StringBuilder.

### StringBuffer vs StringBuilder

- Kemampuan StringBuffer dan StringBuilder cukup sama, bisa digunakan untuk memanipulasi String.
- Yang membedakan adalah, StringBuffer itu thread safe, sedangkan StringBuilder tidak thread safe.
- Jika kita ingin memanipulasi String secara paralel bersamaan, disarankan untuk menggunakan StringBuffer, 
namun jika tidak butuh paralel cukup gunakan StringBuilder.
- Karena StringBuffer dibuat agar thread safe, maka secara otomatis performanya lebih lambat dibandingkan StringBuilder.
- [Dokumentasi StringBuffer](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/StringBuffer.html)
- [Dokumentasi StringBuilder](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/StringBuilder.html)

**Contoh StringBuilder**

```java
public class StringBuilderApp {
    public static void main(String[] args) {
        
        StringBuilder builder = new StringBuilder();
        // append digunakan untuk menambah kan string.
        builder.append("Rifki");
        builder.append(" ");
        builder.append("Rahmattullah");
        
        // Jika kita ingin mengaksesnya
        String name = builder.toString();
        System.out.println(name);
    }
}
```

## StringJoiner Class

- StringJoiner adalah class yang bisa digunakan untuk membuat String sequence yang bisa dipisahkan dengan delimiter.
- StringJoiner juga mendukung prefix dan suffix jika kita ingin menambahkannya.
- Ini sangat bagus ketika ada kasus misal kita ingin mem-print Array dengan format yang kita ingin kan.
- [Dokumentasi StringJoiner](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/StringJoiner.html)

**Contoh StringJoiner**

```java
import java.util.StringJoiner;

public class StringJoinerApp {
    public static void main(String[] args) {

        StringJoiner joiner = new StringJoiner(",", "[", "]");
        
        joiner.add("Rifki");
        joiner.add("Rahmattullah");
        
        String value = joiner.toString();
        System.out.println(value);
    }
}
```

## StringTokenizer Class

- StringTokenizer class adalah class yang bisa digunakan untuk memotong String menjadi token atau string yang lebih kecil.
- Kita bisa memotong String dengan delimiter yang kita mau.
- Akan lebih hemat memory, karena StringTokenizer akan melakukan pemotongan String dengan sedikit demi sedikit.
- [Dokumentasi StringBuilder](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/StringTokenizer.html)

**Contoh StringTokenizer**

```java
import java.util.StringTokenizer;

public class StringTokenizerApp {
    public static void main(String[] args) {
        
        String value = "I love You";
        
        // Pastikan ada delimiter nya
        StringTokenizer tokenizer = new StringTokenizer(" ");
        
        while (tokenizer.hasMoreTokens()){
            String result = tokenizer.nextToken();
            System.out.println(result);
        }
    }
}
```

## Number Class

- Semua number class yang bukan primitif memiliki parent class yang sama yaitu, class number.
- Class number memiliki banyak method yang bisa digunakan untuk mengkonversi ke tipe number lain.
- Hal ini memudahkan kita untuk mengkonversi object number dari satu tipe ke tipe number lainnya.
- [Dokumentasi Number Class](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Number.html)

**Contoh Method di Number Class**

| Method               | Keterangan                   |
|:---------------------|:-----------------------------|
| byte byteValue()     | Mengubah menjadi tipe byte   |
| double doubleValue() | Mengubah menjadi tipe double |
| float floatValue()   | Mengubah menjadi tipe float  |
| int intValue()       | Mengubah menjadi int value   |
| long longValue()     | Mengubah menjadi long value  |
| short shortValue()   | Mengubah menjadi short value |

**Contoh Penggunaannya**

```java
public class NumberApp {
    public static void main(String[] args) {
        
        Integer intValue = 10;
        
        Long longValue = intValue.longValue();
        Double doubleValue = longValue.doubleValue();
        Short shortValue = doubleValue.shortValue();

        System.out.println(longValue);
        System.out.println(doubleValue);
        System.out.println(shortValue);
    }
}
```

### Konversi String ke Number

- Long, Integer, Short dan Byte memiliki static method untuk melakukan konversi dari String ke number.
- parseXxx(string) digunakan untuk mengkonversi dari string ke tipe data number primitif.
- valueOf(string) digunakan untuk mengkonversi dari string ke tipe data number non primitif.
- Method ini akan throw NumberFormatException jika ternyata gagal dalam melakukan konversi String ke number.

**Contoh Konversi String ke Number**

```java
public class NumberApp {
    public static void main(String[] args) {
        
        String number = "10000";
        
        Integer numberInt = Integer.valueOf(number);
        System.out.println(numberInt);
    }
}
```

## Math Class

- Class Math merupakan class utilities yang berisikan banyak sekali static method untuk operasi numeri seperti,
trigonometric, logarithm, akar pangkat, dll.
- [Dokumentasi Math Class](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Math.html)

**Contoh Method di Math Class**

| Method                        | Keterangan                      |
|:------------------------------|:--------------------------------|
| double cos(double)            | Menghitung cos di trigonometric |
| double sin(double)            | Menghitung sin di trigonometric |
| double tan(double)            | Menghitung tan di trigonometric |
| min(number1, number2)         | Menghitung nilai terkecil       |
| max(number1, number2)         | Menghitung nilai terbesar       |
| **dan masih banyak lainnya!** |

**Contoh Penggunaan Method di Math Class**

```java
public class MathApp {
    public static void main(String[] args) {
        
        var min = Math.min(1000, 3000);
        System.out.println(min);
        
        var max = Math.max(1000, 3000);
        System.out.println(max);
    }
}
```

## Big Number Class

- Jika kita ada kebutuhan untuk menggunakan angka yang besar sehingga melebihi kapasitas Long dan Double di Java
sudah disediakan class untuk handle data besar tersebut.
- BigInteger adalah class untuk handle tipe data Integer
- BigDecimal adalah class untuk handle tipe data floating point.
- [Dokumentasi BigInteger Class](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/math/BigInteger.html)
- [Dokumentasi BigDecimal Class](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/math/BigDecimal.html)

**Method di BigInteger & BigDecimal**

| Method                  | Keterangan |
|:------------------------|:----------:|
| add                     |     +      |
| subtract                |     -      |
| multiply                |     *      |
| divide                  |     /      |
| mod                     |     %      |
| **Dan masih bany lagi** |            |

**Contoh Penggunaan**

```java
import java.math.BigInteger;

public class BigNumberApp {
    public static void main(String[] args) {

        BigInteger a = new BigInteger("10000000000000000000000000");
        BigInteger b = new BigInteger("10000000000000000000000000");
        
        BigInteger c = a.add(b);

        System.out.println(c);
    }
}
```

## Scanner Class

- Scanner sebenarnya bagian dari Java IO(Input Output).
- Class Scanner hadir sejak java 5.
- Class Scanner adalah class yang bisa digunakan untuk membaca input, entah dari file, console, dll.
- Class Scanner ini cocok untuk dijadikan object untuk membaca input user saat kita belajar membuat program Java 
menggunakan console/termial.
- [Dokumentasi Scanner Class](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Scanner.html)

**Method di Scanner Class**

| Method        | Keterangan      |
|:--------------|:----------------|
| nextLine()    | Membaca string  |
| nextInt()     | Membaca int     |
| nextLong()    | Membaca long    |
| nextBoolean() | Membaca boolean |

**Contoh Penggunaan**

```java
import java.util.Scanner;

public class ScannerApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama : ");
        String name = scanner.nextLine();

        System.out.print("Umur : ");
        Integer age = scanner.nextInt();

        System.out.println("Hello nama saya " + name + ", umur saya " + age);
    }
}
```

## Date & Calender

- Tiap bahasa pemograman biasanya memiliki representasi tanggal, di Java juga sama, ada class Date & Calender 
yang bisa digunakan sebagai representasi tanggal.
- Sebenarnya di Java 8 sudah ada cara memanipulasi tanggal yang baru menggunakan Java Date Time API.

### Hubungan Date & Calender

- Class Date adalah representasi tanggal presisi milisecond.
- Namun di class Dat sudah banyak method-method yang deprecated, sehingga untuk memanipulasi date tanggal, 
kita sekarang harus melakukan kombinasi antara class Date dan Calender.
- Sederhananya Date untuk  representasi  tanggal, dan Calender untuk memanipulasi tanggal.
- [Dokumentasi Date Class](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Date.html)
- [Dokumentasi Calender Class](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Calender.html)

**Contoh Penggunaanya**

```java
import java.util.Calendar;
import java.util.Date;

public class DateApp {
    public static void main(String[] args) {

        Date tanggal = new Date(23587200000L);

        System.out.println(tanggal);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1945);
        calendar.set(Calendar.MONTH, Calendar.AUGUST);
        calendar.set(Calendar.DATE, 17);
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        
        Date result = calendar.getTime();
        System.out.println(result);
    }
}
```

## System Class

- Class System adalah class yang berisikan banyak utility static method di Java.
- Contohnya kita sudah menggunakan method prinln milik field out di class System.
- [Dokumentasi System Class](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/System.html)

**Method di System Class**

| Method                  | Keterangan                                     |
|:------------------------|:-----------------------------------------------|
| String getenv(key)      | Mendapatkan environment variable siste operasi |
| void exit(status)       | Menghentikan program Java                      |
| long currentTimeMilis() | Mendapatkan waktu saat ini dalam milisecond    |
| long nanoTime()         | Mendpatkan waktu saat ini dalam nano second    |
| void gc()               | Menjalankan Java garbage collection            |

**Contoh Penggunaan**

```java
public class SystemApp {
    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());

        System.out.println(System.getenv("HOME"));
        
        System.exit(1);
    }
}
```

## Runtime Class

- Ketika aplikasi Hava kita berjalan, kita bisa melihat informasi environment tempat aplikasi Java berjalan.
- Informasi itu terdapat di class Runtime.
- Class Runtime tidak bisa dibuat, secara otomatis Java akan membuat single object. 
- Kita bisa mengakses object tersebut menggunakan static method getRuntime() milik class Runtime.
- [Dokumentasi Runtime Class](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Runtime.html)

**Contoh Method di Runtime Class**

| Method                    | Keterangan                                                                                 |
|:--------------------------|:-------------------------------------------------------------------------------------------|
| int availableProcessors() | Mendapatkan jumlah core CPU                                                                |
| long freeMemory()         | Mendapatkan jumlah memory kosong di JVM                                                    |
| long totalMemory()        | Mendapatkan jumlah total memory di JVM                                                     |
| long maxMemory()          | Mendapatkan jumlah maksimum memory di JVM                                                  |
| void gc()                 | Menjalankan garbage collection untuk menghilangkan data di memory yang sudah tidak dipakai |

**Contoh Penggunaan**

```java
public class RuntimeApp {
    public static void main(String[] args) {
        
        Runtime runtime = Runtime.getRuntime();

        System.out.println(runtime.availableProcessors());
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.totalMemory());
        System.out.println(runtime.maxMemory());
    }
}
```

## UUID Class

- Saat membuat aplikasi, kadang kita ada kasus ingin membuat data unique, 
misal untuk kebutuhan data primary key misalnya.
- Java menyediakan sebuah class UUID atau singkatan dari Universally Unique Identifier.
- UUID adalah format stadard utnuk membuat unique value yang telah terjamin.
- [Dokumentasi UUID Class](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/UUID.html)
- [Dokumentasi Standarisasi UUID](https://www.ietf.org/rfc/rfc4122.txt)

**Cara Penggunaan**

```java
import java.util.UUID;

public class UUIDApp {
    public static void main(String[] args) {

        for (var i = 0; i < 100; i++) {

            UUID uuid = UUID.randomUUID();
            String key = uuid.toString();

            System.out.println(key);
        }
    }
}
```

## Base64 Class

- Sejak Java 8, Java sudah menyediakan class untuk melakukan encoding base64.
- Base64 adalah encoding yang bisa digunakan untuk mengubah binary data ke text yang aman(Aman bukan dalam arti security).
- Aman disini bukan dari sisi security, tapi aman dari kesalahan parsing.
- [Dokumentasi Base64 Class](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Base64.html)
- [Dokumentasi Standarisasi Base64](https://www.ietf.org/rfc/rfc4648.txt)

**Contoh Penggunaan**

```java
import java.util.Base64;

public class Base64App {
    public static void main(String[] args) {

        String original = "I Miss You";

        String encoded = Base64.getEncoder().encodeToString(original.getBytes());
        System.out.println(encoded);
        
        byte[] bytes = Base64.getDecoder().decode(encoded);
        String result = new String(bytes);

        System.out.println(result);
    }
}
```

## Objects Class

- Awas jangan tertukar, ini class Objects, bukan Object(tanpa s).
- Objects adalah class utility yang berisikan banyak static method yang bisa kita gunakan untuk operasi object atau 
melakukan pengecekan sebelum operasinya dilakukan.
- [Dokumentasi Objects Class](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Objects.html)

**Contoh Penggunaan**

```java
package rifki.rahmattullah.classes;

import java.util.Objects;

public class ObjectsApp {

    public static class Data {

        private String data;

        public Data(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Data data1 = (Data) o;

            return Objects.equals(data, data1.data);
        }

        @Override
        public int hashCode() {
            return data != null ? data.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "data='" + data + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        /**
         * Dengan menggunakan Objects, jika data nya null maka tidak akan terjadi error NullPointer lagi
         */
        execute(new Data("Rifki"));
    }

    public static void execute(Data data) {
        System.out.println(Objects.toString(data));
        System.out.println(Objects.hashCode(data));
    }
}
```

## Random Class

- Random class adalah class yang bisa kita gunakan untuk men-generate random number.
- [Dokumentasi Random Class](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Random.html)

**Contoh Penggunaan**

```java
import java.util.Random;

public class RandomApp {
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int value = random.nextInt(100);
            System.out.println(value);
        }
    }
}
```

## Properties Class

- Kebanyakan aplikasi Java akan menyimpan konfigurasi file dalam bentuk properties file.
- Properties file adalah file yang berisi key value yang dipisahkan dengan tanda sama dengan(=).
- Properties file bisa kita gunakan untuk menyimpan konfigurasi aplikasi kita.
- Properties Class adalah class yang bisa kita gunakan untuk mengambil atau menyimpan informasi ke file properties.
- [Dokumentasi Properties Class](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Properties.html)

**Contoh Penggunaan**

```java
package rifki.rahmattullah.classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesApp {
    public static void main(String[] args) {

        // Untuk load data konfigurasi dari file application.properties
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("application.properties"));

            String host = properties.getProperty("database.host");
            String port = properties.getProperty("database.port");
            String username = properties.getProperty("database.username");
            String password = properties.getProperty("database.password");

            System.out.println(host);
            System.out.println(port);
            System.out.println(username);
            System.out.println(password);

        }catch (FileNotFoundException exception){
            System.out.println("File tidak ditemukan");
        }catch (IOException exception){
            System.out.println("Gagal load data dari file");
        }

        // Untuk menyimpan data konfigurasi
        try {
            Properties properties = new Properties();
            properties.put("name.first", "Rifki");
            properties.put("name.last", "Rahmattullah");

            properties.store(new FileOutputStream("name.properties"), "Konfigurasi nama");
        }catch (FileNotFoundException exception){
            System.out.println("Error Membuat file properties");
        }catch (IOException exception){
            System.out.println("Error menyimpan properties");
        }

    }
}
```

## Arrays Class

- Arrays class adalah class yang berisikan static method yang bisa kita gunakan untuk memanipulasi data array,
seperti pencarian dan pengurutan.
- [Dokumentasi Arrays Class](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Arrays.html)

**Method di Arrays Class**

| Method                     | Keterangan                        |
|:---------------------------|:----------------------------------|
| binarySearch(array, value) | Mencari value dari array          |
| copyOf()                   | Menyalin data array               |
| equals(array1, array2)     | Membandingkan array1 dan array2   |
| sort(array)                | Mengurutkan array                 |
| toString(array)            | Mengembalikan representasi string |

**Contoh Penggunaan**

```java
package rifki.rahmattullah.classes;

import java.util.Arrays;

public class ArraysApp {
    public static void main(String[] args) {

        int[] numbers = {
                1, 6, 92, 83, 12, 19, 68, 20, 30, 70, 193, 302
        };

        Arrays.sort(numbers);

        System.out.println(Arrays.toString(numbers));

        System.out.println(Arrays.binarySearch(numbers, 193));
        System.out.println(Arrays.binarySearch(numbers, 68));
        System.out.println(Arrays.binarySearch(numbers, 100));

        int[] result = Arrays.copyOf(numbers, 5);
        System.out.println(Arrays.toString(result));

        int[] result2 = Arrays.copyOfRange(numbers, 5, 10);
        System.out.println(Arrays.toString(result2));
    }
}
```

## Regular Expression

- Regular Expression atau disingkat Regex adalah cara untuk melakukan pola pencarian.
- Biasanya dilakukan untuk pencarian data String.
- Secara sederhana, kita mungkin sudah sering melakukan pencarian text, entah itu di editor atau di applikasi word.
- Regex adalah pencarian yang lebih advanced dibanding pencarian text biasa, 
misalnya kita ingin mencari semua kata yang diawali huruf A dan diakhiri dengan huruf A, dll.

### Regex Package

- Java sudah menyediakan package java.util.regex yang berisikan utilitas untuk melakukan proses regex.
- Secara garis besar terdapat 2 class yang dapat kita gunakan yaitu, Pattern class dan Matcher class.
- Pattern class adalah reperesentasi hasil kompilasi dari pola regex yang kita buat.
- Matcher class adalah engine untuk melakukan pencarian dari pattern yang sudah kita buat.
- Regex memiliki banyak sekali aturan.
- [Dokumentasi Regex](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/regex/Pattern.html)

**Contoh Penggunaan**

```java
package rifki.rahmattullah.classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexApp {
    public static void main(String[] args) {

        String text = "Nama saya Rifki Rahmattullah saya ingin menjadi seorang Software Engineer";

        Pattern pattern = Pattern.compile("[a-zA-Z]*[a][a-zA-Z]*");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            String result = matcher.group();
            System.out.println(result);
        }
    }
}
```
