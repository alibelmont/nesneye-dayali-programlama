# nesneye-dayali-programlama

Başta film ve müşteri bilgilerini tutmak için diziler tanımladım.

Menü yapısı için switch-case kullandım. Kullanıcının seçimine göre ilgili işlemi yapan fonksiyon çağrılıyor.

Scanner ile kullanıcıdan veri alınıyor. scanner.close() komutunu her işlemde değil, program sonunda bir kez kullandım.

Film ve müşteri ekleme işlemlerinde scanner.nextLine() kullandım ki ad-soyad veya film adları boşluk içerse bile tüm metin alınsın.

Bilet oluşturma işleminde, kullanıcıdan film ve müşteri numaraları alınarak bilet ilişkisi, iki boyutlu bir diziye kaydediliyor.

Son olarak, tüm biletler ve eşleşen bilgiler, for döngüsü ile sıralı şekilde kullanıcıya gösteriliyor.
