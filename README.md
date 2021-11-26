# CicekSepeti-TestAutomation-HW1-BurakBayramoglu

Çiçeksepeti Test Otomasyon 1. Hafta Ödevi

TR

Bu projede 2 class ile toplamda 4 adet test senaryosu bulunmaktadır. Selenium ve JUnit kullanılmıştır.


Case 1 : Geçersiz Referans Değerleri İle Giriş Yapılma Testi

- https://www.ciceksepeti.com/uye-girisi adresine gidilir.
- Tarayıcı tam ekran yapılır.
- Dummy bilgiler ile giriş denemesi yapılır. (Yanlış eposta/şifre)
- Ekrana gelen uyarı penceresindeki yazılar kontrol edilir.
- Beklenen hata penceresi gelmiş ise pencere onaylanarak kapatılır.

Case 2 : Geçersiz Referans Değerleri İle Giriş Yapılma Testi

- https://www.ciceksepeti.com/uye-girisi adresine gidilir.
- Tarayıcı tam ekran yapılır.
- Çiçeksepeti veritabanında kayıtlı olan geçerli bilgiler ile giriş denemesi yapılır. (Login.java dosyasında 54. ve 55. satırın geçerli giriş bilgileri ile düzenlenlenmesi gerekmektedir!)
- Giriş ardından yönlendirilmiş olduğunuz anasayfada açılacak olan popup kapatılmaya çalışılır. Popup başarı ile kapatılır ile Case başarı ile tamamlanmış anlamına gelir.

Case 3 : Sepete Rastgele Ürün Ekleme Testi
- https://www.ciceksepeti.com/bluetooth-kulaklik adresine gidilir.
- Tarayıcı tam ekran yapılır.
- Açılan Popup kapatılır.
- Rastgele seçilen ilk 5 üründen birisine tıklanır.
- Görüntülenen ürünün ismi daha sonra kıyaslanmak üzere kaydedilir.
- Görüntülenen ürün sepete eklenir.
- Otomatik olarak yönlendirilmiş olduğunuz Sepetim sayfasında bulunan ürünün ismi kaydedilir.
- Kaydedilen iki ürün ismi kıyaslanır.

Case 4 : Sepete Gül Ekleme Hata Testi
- https://www.ciceksepeti.com/bluetooth-kulaklik adresine gidilir. 
- Tarayıcı tam ekran yapılır.
- Açılan Popup kapatılır.
(Setup fonksiyonunun yapısından dolayı Case 3'de bulunan ilk 3 adım tekrar gerçekleşmiştir.)
- https://www.ciceksepeti.com/guller adresine gidilir.
- Karşılaşılan ilk sonuç seçilir.
- Sipariş ver butonuna tıklanır.
- Karşılaşılan hata ve beklenilen hata kıyaslanır.
