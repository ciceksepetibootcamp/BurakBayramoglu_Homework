PYTEST https://thebouqet.com/ TESTLERİ

Projeyi çalıştırabilmek için Python ve gerekli modüllerin kurulumunun ardından Tests/test.py dosyasındaki 16. satırında bulunan chromedriver path'i düzenlenmelidir.


#Sepete Başarılı Ürün Ekleme Testi

Sepete belirtilen sayıda ürünün eklenip eklenemediğini kontrol eder. Eklenecek ürün sayısı 27. satırda bulunan "additems = 2" değişkeni ile ayarlanabilir. Sepetteki ürün sayısı ile "additem" değişkeni eşleşiyor mu kontrolü sağlanır.


#Sepet Boşaltma Testi

Öncelikle "additem" değişkeni kullanılarak sepete istenilen miktarda ürün eklenerek sepet test için hazır hale getirilir. Ardından sepetteki ürün sayısı 0 olana kadar çıkartma işlemi yapılmaya çalışılır. Son olarak sepet boşaldığında karşılaşılması beklenilen "Sepetinizde hiç ürün yok !" metni kontrol edilir.


#Sepetteki Ürün Mikarını Düzenleme Testi

Sepette yapılabilecek işlemlerden bir diğeri sepette bulunan ürünün miktarını arttırmak veya azaltmak. Bu testimizde bu fonksiyonun çalışıp çalışmadığını ve matematiksel hesaplamaları doğru yapıp yapmadığını kontrol etmekteyiz. Öncelikle sepete Tests/test.py dosyasının 71. satırında bulunan "home_page.add_item_to_basket(1)" fonksiyonu çağrılarak sepete bir adet ürün eklenir. Ardından 75. satırda bulunan "newitemamouth = 5" değişkeni ile yeni ürün miktarı set edilir. "per_item_price" ile tekil ürün fiyatı bulunur ve set edilen yeni ürün miktarı değişkeni ile çarpılarak öngörülen maliyet bir değişkene atanır. Ürün miktarı değiştirilmeye çalışılır ve sayfa yenilenmesinin ardından öngörülen maliyet ile yenileme ardından toplam sepet maliyeti eşit mi kontrolü sağlanır.



