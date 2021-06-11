# Prototype

### Pengertian
- GOF : Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.
- Tentukan jenis object yang akan dibuat menggunakan contoh prototype, dan buat objek baru dengan menyalin object prototypenya

### Motivasi
- Pada beberapa kasus, kita sering sekali memulai pembuatan object dengan beberapa data yang sama
- Jika kita membuat object tersebut secara manual satu persatu, maka akan rentang terhadap kesalahan, terutama ketika object dengan jenis tertentu harus berubah datanya.
- Prototype pattern merupakan pattern dimana kita akan membuat object prototype, lalu saat kita membuat object baru, kita tidak perlu membuat object dari awal lagi, kita cukup menyalin data dari object prototype
- Hal ini membuat pembuatan object lebih mudah, dan jika data prototype ingin diubah, kita bisa dengan mudah mengubah prototype, dan secara otomatis semua object baru dari prototype tersebut akan berubah datanya

### Struktur
![screenshot1](screenshot/Screenshot_1.png)

### Keuntungan
- Menambah dan menghapus prototype object sangat mudah, karena bukan sub-class, sehingga menambah dan menghapus prototype object tidak sesulit jika menggunakan class inheritance
- Membuat jenis object baru sangat mudah, hanya dengan menambah atau mengubah attribute object prototype, tidak perlu ada penambahan class baru
- Menurunkan jumlah subclass, pada pattern Factory Method, kadang menghasilkan class hirarki yang banyak, prototype bisa mencegah terjadinya class hirarki terlalu banyak
- Prototype object bahkan bisa dibuat saat runtime (aplikasi berjalan), karena tidak membutuhkan deklarasi class baru

### Prototype Pattern di Spring Boot
- Kita sudah tahu secara default bean di Spring adalah singleton, artinya ketika kita kases beannya, sebenarnya dia adalah object yang sama
- Di Spring, kita bisa ubah scope bean dari singleton menjadi prototype. Saat kita ubah menjadi prototype, secara otomatis object akan selalu dibuat baru sesuai dengan deklarasi yang ada di bean
- Dengan demikian, implementasi prototype di Spring sangat mudah

### Kapan Menggunakan Prototype Pattern
- Saat kita memiliki sebuah class yang jenis objectnya banyak kesamaan, maka sangat cocok menggunakan prototype pattern
- Dengan prototype pattern, kita bisa membuat object dari prototype bean yang sudah kita deklarasikan
- Hati-hati ketikamembuat bean dari prototype, karena secara otomatis object akan selalu dibuat baru oleh Spring

### Contoh Kasus
- Mulai kita akan membuat aplikasi kepegawaian, dimana terdapat data Employee
- Setiap Employee memiliki title / jabatan masing-masing, dan salary-nya selalu sama antar title
- Pada kasus ini, kita bisa menggunakan prototype pattern untuk membuat object Employee, dimana kita bisa buat beberapa prototype sesuai dengan titlenya

### Kode : Class Employee
```java
public class Employee {
    private String id;
    private String name;
    private Position position;
    private Long salary;
}
```

### Kode : Membuat Prototype
```java
@Bean
@Scope("prototype")
public Employee employeeManager() {
    Employee employee = new Employee();
    employee.setPosition(Position.MANAGER);
    employee.setSalary(20_000_000L);
    return employee;
}
```

```java
@Bean
@Scope("prototype")
public Employee employeeStaff() {
    Employee employee = new Employee();
    employee.setPosition(Position.STAFF);
    employee.setSalary(10_000_000L);
    return employee;
}
```

### Kode : Membuat Object dari Prototype
```java
Employee eko = applicationContext.getBean("employeeManager", Employee.class);
eko.setName("Eko");

Employee budi = applicationContext.getBean("employeeStaff", Employee.class);
budi.setName("Budi");

Employee joko = applicationContext.getBean("employeeStaff", Employee.class);
joko.setName("Joko");
```