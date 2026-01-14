# 📚 Library Management System

מערכת לניהול ספרייה - פרויקט Full Stack עם React ו-Spring Boot

## 📋 תיאור הפרויקט

מערכת ניהול ספרייה מקיפה המאפשרת ניהול ספרים, לקוחות והשאלות. הפרויקט בנוי באמצעות ארכיטקטורת Client-Server עם ממשק משתמש מודרני ב-React ושרת Backend חזק ב-Spring Boot.

## 🏗️ ארכיטקטורת הפרויקט

```
frontEndProjectJavaWhithReact/
├── client/                    # React Frontend
│   ├── src/
│   │   ├── components/       # קומפוננטות React
│   │   │   ├── Book/        # ניהול ספרים
│   │   │   ├── Customer/    # ניהול לקוחות
│   │   │   └── Lending/     # ניהול השאלות
│   │   ├── services/        # שירותי API
│   │   ├── App.js           # קומפוננטת ראשית
│   │   └── index.js         # נקודת כניסה
│   └── public/
│
└── server/demo/              # Spring Boot Backend
    └── src/main/java/com/example/demo/
        ├── Controller/       # REST API Controllers
        ├── Service/          # Business Logic
        ├── Repository/       # Data Access Layer
        ├── Entity/           # JPA Entities
        └── Dto/              # Data Transfer Objects
```

## 🌟 תכונות עיקריות

### 📖 ניהול ספרים
- הוספת ספרים חדשים למערכת
- עריכת פרטי ספרים קיימים
- חיפוש ספרים לפי:
  - מזהה
  - שם הספר
  - שנת הוצאה
- הצגת כל הספרים במערכת
- מעקב אחר סטטוס זמינות הספרים

### 👥 ניהול לקוחות
- הוספת לקוחות חדשים
- חיפוש לקוח לפי מזהה (ת.ז)
- הצגת כל הלקוחות במערכת
- מעקב אחר השאלות של כל לקוח

### 🔄 ניהול השאלות
- רישום השאלה חדשה
- החזרת ספרים
- חיפוש השאלות לפי לקוח
- חישוב קנסות עבור איחור בהחזרה (0.5 ₪ ליום אחרי 14 יום)
- מניעת השאלה כפולה של אותו ספר

## 🛠️ טכנולוגיות

### Frontend
- **React** - ספריית JavaScript לבניית ממשק משתמש
- **React Router** - ניווט בין דפים
- **Fetch API** - תקשורת עם השרת
- **CSS3** - עיצוב וממשק משתמש

### Backend
- **Spring Boot** - Framework לבניית אפליקציות Java
- **Spring Data JPA** - ניהול בסיס נתונים
- **Spring Web** - RESTful API
- **Hibernate** - ORM Framework
- **Jakarta Validation** - ולידציה של נתונים

## 📦 התקנה והרצה

### דרישות מקדימות
- Node.js (גרסה 14 ומעלה)
- Java JDK (גרסה 17 ומעלה)
- Maven
- MySQL / H2 Database

### התקנת Frontend

```bash
cd client
npm install
npm start
```

האפליקציה תרוץ על: `http://localhost:3000`

### התקנת Backend

```bash
cd server/demo
mvn clean install
mvn spring-boot:run
```

השרת ירוץ על: `http://localhost:8080`

## 🔌 API Endpoints

### Books API
```
GET    /book/getAll                  - קבלת כל הספרים
GET    /book/getByIb/{id}           - קבלת ספר לפי מזהה
GET    /book/getByName/{name}       - קבלת ספר לפי שם
GET    /book/getByPublishDate/{year} - קבלת ספרים לפי שנת הוצאה
POST   /book/add                     - הוספת ספר חדש
PUT    /book/update/{id}             - עדכון ספר קיים
```

### Customers API
```
GET    /customer/getAll              - קבלת כל הלקוחות
GET    /customer/getById/{id}        - קבלת לקוח לפי מזהה
POST   /customer/add                 - הוספת לקוח חדש
```

### Lendings API
```
GET    /lending/getAll               - קבלת כל ההשאלות
GET    /lending/getAllById/{id}      - קבלת השאלות לפי לקוח
GET    /lending/pay/{id}             - חישוב קנס עבור לקוח
POST   /lending/add                  - הוספת השאלה חדשה
PUT    /lending/returnBook/{id}      - החזרת ספר
```

## 📊 מודל הנתונים

### Entities

#### Book (ספר)
- `bookId` - מזהה ייחודי (Auto-generated)
- `bookName` - שם הספר
- `author` - שם המחבר
- `releaseDate` - תאריך הוצאה
- `lendings` - רשימת השאלות

#### Customer (לקוח)
- `customerId` - תעודת זהות (מזהה ייחודי)
- `fName` - שם פרטי
- `lName` - שם משפחה
- `phone` - מספר טלפון
- `lendings` - רשימת השאלות

#### Lending (השאלה)
- `lendingId` - מזהה ייחודי (Auto-generated)
- `customer` - הלקוח המשאיל
- `book` - הספר המושאל
- `lendingDate` - תאריך ההשאלה
- `returned` - סטטוס החזרה (true/false)

## 🎨 ממשק המשתמש

הממשק בנוי בעברית (RTL) ומציע:
- ניווט פשוט בין מסכים שונים
- טפסים ברורים להוספה ועריכה
- טבלאות מסודרות להצגת מידע
- חיפוש מתקדם עם מספר פרמטרים
- התראות וודאות למשתמש

## 🔐 חוקי עסקיים

1. **מניעת השאלה כפולה** - ספר שהושאל ולא הוחזר לא ניתן להשאיל שוב
2. **חישוב קנס** - לאחר 14 יום מההשאלה, קנס של 0.5 ₪ ליום
3. **ולידציה של נתונים**:
   - תעודת זהות חייבת להיות בת 9 ספרות
   - כל השדות הנדרשים חייבים להיות מלאים
4. **קשרים בין ישויות**:
   - לקוח יכול להשאיל ספרים מרובים
   - ספר יכול להישאל למספר לקוחות (לא במקביל)

## 🚀 תכונות מתקדמות

- **Lazy Loading** - טעינה יעילה של נתונים
- **Error Handling** - טיפול מקיף בשגיאות
- **RESTful API** - ממשק API סטנדרטי
- **DTO Pattern** - הפרדה בין Entity ל-Data Transfer Objects
- **Service Layer** - הפרדת לוגיקה עסקית
- **Repository Pattern** - גישה לבסיס הנתונים
- **CORS Configuration** - תמיכה ב-Cross-Origin Requests

## 📝 דוגמאות שימוש

### הוספת ספר חדש
1. היכנס למסך "ספרים"
2. מלא את הפרטים בטופס:
   - **שם הספר**: הארי פוטר
   - **מחבר**: ג'יי קיי רולינג
   - **תאריך הוצאה**: 1997-06-26
3. לחץ על כפתור "הוסף ספר"

### הוספת לקוח חדש
1. היכנס למסך "לקוחות"
2. מלא את הפרטים בטופס:
   - **מזהה לקוח (ת.ז)**: 123456789
   - **שם**: יוסי
   - **טלפון**: 050-1234567
3. לחץ על כפתור "הוסף לקוח"

### יצירת השאלה
1. היכנס למסך "השאלות"
2. מלא את הפרטים בטופס:
   - **מזהה לקוח**: 123456789
   - **מזהה ספר**: 1
   - **תאריך השאלה**: 2025-01-14
3. לחץ על כפתור "הוסף השאלה"

### חיפוש והחזרת ספר
1. במסך "השאלות", הזן מזהה לקוח בשדה החיפוש
2. לחץ על "חפש" כדי לראות את כל השאלות של הלקוח
3. לחץ על "סמן כהוחזר" ליד ההשאלה הרלוונטית

## 🤝 תרומה לפרויקט

1. Fork את הפרויקט
2. צור branch חדש (`git checkout -b feature/AmazingFeature`)
3. Commit את השינויים (`git commit -m 'Add some AmazingFeature'`)
4. Push ל-branch (`git push origin feature/AmazingFeature`)
5. פתח Pull Request

## 📄 רישיון

פרויקט זה הוא קוד פתוח וזמין לשימוש חופשי.

## 👨‍💻 מפתחים

פרויקט פותח כחלק מקורס Full Stack Development

## 📞 יצירת קשר

לשאלות והצעות, אנא פנה דרך GitHub Issues של הפרויקט.

---

**הערה**: יש לוודא שבסיס הנתונים פועל לפני הפעלת השרת ושה-Backend פועל לפני הפעלת ה-Frontend.
