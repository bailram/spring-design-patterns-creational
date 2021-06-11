# Builder Pattern

### Pengertian
- GOF : Separate the construction of a complex object from its representation so that the same construction process can create different representations.
- Memisahkan pembuatan object yang kompleks dari representasi sehingga proses pembuatan yang dapat membuat representasi yang berbeda.

### Motivasi
- Pada kenyataannya, kita sering kali menemui class yang sangat kompleks dan butuh banyak hal yang perlu disiapkan sebelum membuat object dari class tersebut
- Ada baiknya pada kasus ini, kita implementasikan builder pattern
- Dalam builder pattern, kita akan membuat builder class, yang digunakan sebagai class untuk melakukan konstruksi pembuatan class yang telah ditentukan

### Struktur
![screenshot1](screenshot/Screenshot_1.png)

### Keuntungan
- Memisahkan kompleksitas konstruksi object dari class nya
- Menghilangkan kompleksitas class dari client, sehingga client hanya perlu menggunakan builder ketika membuat instance object
- Pembuatan object dengan builder dilakukan terhadap step by step, ini membuat client lebih mudah ketika pembuatan object dibandingkan langsung menggunakan constructor atau function/method

### Builder Pattern di Spring Boot
- Builder pattern adalah salah satu pattern yang sangat berguna untuk membuat complex object, namun sayangnya implemtasi builder pattern secara manual tidaklah menyenangkan
- Seandainya kita perlu membuat complex object dengan puluhan attribute, maka kita juga perlu membuat builder class yang berisi puluhan method untuk mempersiapkan attribute tersebut
- Oleh karena itu, banyak sekali library yang memang sengaja dibuatkan untuk implementasi ini, salah satunya adalah library Lomok, yang biasa digunakan di Spring Boot
- Dengan menggunakan library Lombok, kita bisa membuat builder class hanya dengan annotation @Builder pada class complexnya

### Kapan Menggunakan Builder Pattern
- Saat kita membuat class yang complex dan banyak attribute sangat disarankan menggunakan builder pattern
- Builder pattern bisa digabungkan dengan pattern lainnya, misal pembuatan singleton object bisa menggunakan builder patter, atau pembuatan prototype object juga bisa menggunakan builder pattern
- Bahkan saya sendiri selalu menggunakan builder pattern, jika membuat class Model/Data/Entity untuk mempermudah proses pembuatan objectnya, tanpa harus memikirkan jumlah parameter di constructor

### Contoh Kasus
- Misal kita membuat aplikasi toko online, dimana memerlukan data Product
- Data product merupakan data yang kompleks, karena banyak sekali attribute yang terdapat di Product
- Membuat object Product menggunakan constructor atau menggunakan function satu persatu sangatlah melelahkan, oleh karena itu, lebih baik kita menggunakan builder pattern

### Kode : Class Product
```java
@Builder
public class Product {
    private String id;
    private String name;
    private Long price;
    private String sku;
}
```

### Hasil Product Builder
```java
public static Product.ProductBuilder builder() {
    return new Product.ProductBuilder();
}

public static class ProductBuilder {
    private String id;
    private String name;
    private Long price;
    private String sku;
}
```

### Kode : Membuat Object dengan Builder
```java
Product iphone = Product.builder()
        .id("XXX")
        .name("iPhone XXX")
        .category(Category.GADGET)
        .price(25_000_000L)
        .build();
```

### Kode : Prototype menggunakan Builder
```java
@Bean
@Scope("prototype")
public Product productGadget() {
    return Product.builder()
        .category(Category.GADGET)
        .build();
}
```