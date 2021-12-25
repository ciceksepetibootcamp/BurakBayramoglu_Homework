C# .net https://thebouqet.com/ Testleri

Projeyi çalıştırabilmek için C# ve gerekli modüllerin kurulumunun ardından PageObject/BasePage.cs dosyasındaki 20. satırında bulunan chromedriver path'i düzenlenmelidir.

#Sepete Başarılı Ürün Ekleme Testi

Sepete bir adet ürün eklenir. Sepetteki ürün textinin "Sepetiniz (1)" olup olmadığı kontrol edilir.

#Sepet Boşaltma Testi

Öncelikle sepete bir adet ürün eklenerek sepet test için hazır hale getirilir. Ardından sepetteki ürün sepetten çıkartılmaya çalışılır. Son olarak sepet boşaldığında karşılaşılması beklenilen "Sepetiniz (0)" textinde sepetteki ürün miktarını temsil eden kısmın "0" olup olmadığı kontrol edilir.

#Sepetteki Ürün Mikarını Düzenleme Testi

Sepette yapılabilecek işlemlerden bir diğeri sepette bulunan ürünün miktarını arttırmak veya azaltmak. Bu testimizde bu fonksiyonun çalışıp çalışmadığınıkontrol etmekteyiz. Öncelikle sepete tests.cs dosyasının 53. satırında bulunan "homepage.addToBasket()" fonksiyonu çağrılarak sepete bir adet ürün eklenir. Ardından 56. satırda bulunan "newItemQuantity" değişkeni ile yeni ürün miktarı set edilir. Ürün miktarı değiştirilmeye çalışılır ve sayfa yenilenmesinin ardından ürün miktarı 56. satıreda set edilen "newItemQuantity" değişkeni ile eşit olup olmadığı kontrol edilir.
