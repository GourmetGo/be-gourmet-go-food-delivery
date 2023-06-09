1.In folderul controller au loc urmatoarele procese:
 1.1.CourierController acest controller se ocupă cu gestionarea solicitărilor legate de curieri.
 1.2.CustomerController acest controller se ocupă cu gestionarea solicitărilor legate de clienți.
 1.3.Clasa RestaurantController este o parte esențială a aplicației care gestionează solicitările web legate de restaurante, produse și comenzi.
 
 
2.In folderul dto au loc urmatoarele procese:
 2.1.Folderul response/user in care:
  2.1.1.UserResponseDto: Aceasta este o clasă abstractă care reprezintă baza pentru toate tipurile de utilizatori. Conține informații generale despre utilizator, cum ar fi id, nume de utilizator, parolă, email și număr de telefon.
  2.1.2.CourierResponseDto: Această clasă este o extensie a clasei UserResponseDto și reprezintă un răspuns specific pentru un curier. Pe lângă câmpurile moștenite de la UserResponseDto, mai are și câmpurile firstname și lastname.
  2.1.3.CustomerResponseDto: Similar cu CourierResponseDto, această clasă extinde UserResponseDto pentru a reprezenta un răspuns specific pentru un client. Conține câmpuri suplimentare precum firstname, lastname, address și orders. Acesta din urmă este o listă de comenzi asociate clientului.
  2.1.4.RestaurantResponseDto: Această clasă, de asemenea, extinde UserResponseDto, însă reprezintă un răspuns specific pentru un restaurant. Are câmpuri suplimentare precum name, address, products și orders. Products este o listă de produse asociate restaurantului, iar orders este o listă de comenzi asociate restaurantului.
 
 2.2.Folderul request in care:
  2.2.1.OrderRequestDto: Această clasă reprezintă datele necesare pentru a crea o nouă comandă. Conține un câmp courier, care este optional (poate fi null), reprezentând curierul care va livra comanda. De asemenea, conține o listă de produse, products, care sunt produsele comandate.
  2.2.2.ProductRequestDto: Această clasă reprezintă datele necesare pentru a crea un nou produs. 
  2.2.3.Folderul user in care:
   2.2.3.1.UserRequestDto: Aceasta este o clasă abstractă care definește câmpurile comune necesare pentru orice tip de utilizator.
   2.2.3.2.CourierRequestDto: Această clasă este utilizată pentru a înregistra un nou curier în sistem.
   2.2.3.3.CustomerRequestDto: Această clasă este utilizată pentru a înregistra un nou client în sistem.
   2.2.3.4.RestaurantRequestDto: Această clasă este utilizată pentru a înregistra un nou restaurant în sistem. 
   
3.In folderul exception au loc urmatoarele procese:
 3.1.BadRequestException: Aceasta este o excepție personalizată care este aruncată când o cerere de la client nu poate fi procesată deoarece conține date greșite sau necorespunzătoare.  
 3.2.NotFoundException: Aceasta este o excepție personalizată care este aruncată atunci când o resursă solicitată nu a fost găsită.
 
4.Folderul model este folosit pentru a găzdui clasele care reprezintă entitățile din aplicatie.
 
5.In folderul service au loc urmatoarele procese:
 5.1.Clasa CourierService este o componentă de serviciu care gestionează operațiunile legate de curieri în aplicație.
 5.2.Clasa CustomerService este similară cu CourierService, dar se ocupă de operațiunile legate de clienți.
 5.3.Clasa ProductService este un serviciu care gestionează operațiunile legate de produse în aplicație. 
 5.4.Clasa RestaurantService este un serviciu care gestionează operațiunile legate de restaurante.

6.In folderul utils au loc urmatoarele procese:
 6.1.Clasele OrderStatus și ProductCategory sunt clase utilitare care conțin constante utilizate în aplicație.
