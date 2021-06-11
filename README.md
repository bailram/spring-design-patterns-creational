# Abstract Factory Pattern

### Pengertian
- GOF : Provide an interface for creating families of related or dependent objects without specifying their concrete classes.
- Menyediakan sebuah interface untuk membuat keluarga object yang saling berkaitan tanpa perlu menentukan class konkretnya
- Kadang disebut juga dengan pattern Kit

### Motivasi
- Abstract Factory pattern sebenarnya merupakan lanjutan dari Factory Method pattern
- Pada Factory Method pattern, kita hanya fokus membuat satu buat object dari interface, pada kenyataanya, sering sekali kita bertemu dengan object-object yang saling terkait dalam satu keluarga yang sama
- Misal ketika membuat aplikasi dekstop, terdapat interface Window, Dialog, Button, dan lain-lain, lalu terdapat class implementasinya, namun dalam aplikasi dekstop biasanya terdapat tema,sehingga bisa kita group semua implementasi classnya dalam tema, misal DarkWindows, DarkDialog, dan lain-lain
- Dengan kasus seperti itu, kita bisa membuat interface WidgetFactory, lalu membuat class implementasi DarkWidgetFactory, LightWeightFactory, yang didalam factorynya terdapat method untuk membuat Window, Dialog, dan lain-lain

### Struktur
![screenshot1](screenshot/Screenshot_1.png)

### Keuntungan
- Jika diperhatikan Abstract Factory sebenarnya mirip dengan Factory Method dengan struktur inheritance, yang membedakan pada Abstract Factory, tidak hanya terdapat satu method, karena memang tujuannya adalah menggabungkan pembuatan object yang satu keluarga atau grup
- Abstract Factory mengeliminasi ketergantungan antara client dengan class yang spesifik, karena client hanya butuh berinteraksi dengan Product interfacenya
- Membuat object dengan menggunakan abstract factory sangat flexible dibandingkan harus membuat object secara langsung
- Perubahan atau pergantian class konkrit pada abstract factory tidak perlu dirisaukan oleh client, karena client hanya berinteraksi dengan Product interfacenya

### Abstract Factory Pattern di Spring Boot
- Sebelumnya pada Factory Method inheritance, kita tidak membuat Factory classnya, hal ini dikarenakan sudah ditangani dengan baik oleh BeanFactorynya Spring
- Namun, karena pada Abstract Factory, kita perlu menggabungkan factory method yang satu keluarga, maka tidak perlu membuat class Abstract Factory sendiri
- Namun untuk class Abstract Factory nya, kita perlu buat secara singleton, karena harusnya semua client akan menggunakan Abstract Factory yang sama

### Kapan Menggunakan Abstract Factory Pattern
- Ketika kita butuh membuat object dari interface, namun tidak perlu peduli dengan implementasi concrete classnya
- Ketika object dari interface, bisa berubah-ubah sesuai parameter yang kita berikan pada factory method
- Ketika interface tersebut memiliki keluarga yang saling berkaitan

### Contoh Kasus
- Kita sedang membuat Payment Gateway, dimana payment gateway yang akan kita buat mendukung banyak sekali Payment Method
- Operasi pada payment gateway hampir mirip untuk semua payment method, misal ChargeRequest, GetBalanceRequest dan CancelRequest
- Pada kasus ini, kita bisa buat PaymentFactory sebagai Abstract Factory class, lalu kita buat implementasi untuk tiap keluarga payment methodnya, misal CreditCardPaymentFactory, KlikBCAPaymentFactory, GoPayPaymentFactory dan lain-lain
- Dimana PaymentFactory berisi factory method untuk membuat object ChargeRequest, GetBalanceRequest dan CancelRequest

### Kode : Interface Charge Request
```java
public interface PaymentChargeRequest {
    String getId();
    void setId(String id);
    Long getAmount();
    void setAmount(Long amount);
    Long getFee();
    PaymentMethod getMethod();
}
```

### Kode : Interface Cancel Request
```java
public interface PaymentCancelRequest {
    String getId();
    void setId(String id);
    PaymentMethod getMethod();
}
```

### Kode : Class Payment Factory
```java
public interface PaymentFactory {
    PaymentChargeRequest createChargeRequest();
    PaymentCancelRequest createCancelRequest();
}
```

### Kode : Credit Card Payment Factory
```java
@Configuration
public interface CreditCardPaymentFactory implements PaymentFactory {
    @Override
    public PaymentChargeRequest createChargeRequest() {
        return CreditCardPaymentChargeRequest.builder().build();
    }

    @Override
    public PaymentChargeRequest createCancelRequest() {
        return CreditCardPaymentCancelRequest.builder().build();
    }
```

### Kode : Menggunakan Abstract Factory
```java
@Test
void testAbstractFactory() {
    CreditCardPaymentFactory creditCardPaymentFactory = applicationContext.getBean(CreditCardPaymentFactory.class);
    GoPayPaymentFactory goPayPaymentFactory = applicationContext.getBean(GoPayPaymentFactory.class);
    
    testPayment(creditCardPaymentFactory);
    testPayment(goPayPaymentFactory);
}

void testPayment(PaymentFactory paymentFactory) {
    PaymentChargeRequest chargeRequest = paymentFactory.createChargeRequest();
    PaymentCancelRequest cancelRequest = paymentFactory.createCancelRequest();
    
    System.out.println(chargeRequest);
    System.out.println(cancelRequest);
}
```