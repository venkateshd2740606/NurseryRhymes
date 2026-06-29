package com.nurseryrhymes.engine

import com.nurseryrhymes.domain.model.Rhyme
import com.nurseryrhymes.domain.model.RhymeCategory

object RhymeBank {

    val all: List<Rhyme> = listOf(
        rhyme(
            id = 1,
            title = "Twinkle Twinkle Little Star",
            category = RhymeCategory.RHYME,
            illustration = "⭐",
            lines = listOf(
                "Twinkle, twinkle, little star,",
                "How I wonder what you are!",
                "Up above the world so high,",
                "Like a diamond in the sky.",
                "Twinkle, twinkle, little star,",
                "How I wonder what you are!"
            ),
            hindiTitle = "ट्विंकल ट्विंकल छोटे तारे",
            teluguTitle = "Merise merise chinna chukka",
            tamilTitle = "மின்னி மின்னி சின்ன நட்சத்திரம்",
            kannadaTitle = "ಮಿಂಕಲ್ ಮಿಂಕಲ್ ಚಿಕ್ಕ ನಕ್ಷತ್ರ",
            malayalamTitle = "തിളങ്ങി തിളങ്ങി ചെറിയ നക്ഷത്രം",
            hindiLines = listOf(
                "ट्विंकल ट्विंकल छोटे तारे,",
                "कैसे हो तुम प्यारे?",
                "आसमान में ऊँचे हो,",
                "हीरे जैसे चमकते हो!"
            ),
            teluguLines = listOf(
                "Merise merise chinna chukka,",
                "Nuvvu ela unnavu?",
                "Paiki paiki chukkalu,",
                "Vajram la meristunnavi!"
            ),
            tamilLines = listOf(
                "மின்னி மின்னி சின்ன நட்சத்திரம்,",
                "நீ எப்படி இருக்கிறாய்?",
                "வானில் உயரமாக,",
                "வானத்தில் வைரம் போல!"
            ),
            kannadaLines = listOf(
                "ಮಿಂಕಲ್ ಮಿಂಕಲ್ ಚಿಕ್ಕ ನಕ್ಷತ್ರ,",
                "ನೀನು ಹೇಗಿದ್ದೀಯ?",
                "ಆಕಾಶದಲ್ಲಿ ಎತ್ತರ,",
                "ವಜ್ರದಂತೆ ಹೊಳೆಯುತ್ತೀಯ!"
            ),
            malayalamLines = listOf(
                "തിളങ്ങി തിളങ്ങി ചെറിയ നക്ഷത്രം,",
                "നീ എങ്ങനെയിരിക്കുന്നു?",
                "ആകാശത്തിൽ ഉയരെ,",
                "വജ്രം പോലെ മിന്നുന്നു!"
            )
        ),
        rhyme(
            id = 2,
            title = "Baa Baa Black Sheep",
            category = RhymeCategory.RHYME,
            illustration = "🐑",
            lines = listOf(
                "Baa, baa, black sheep,",
                "Have you any wool?",
                "Yes sir, yes sir,",
                "Three bags full.",
                "One for the master,",
                "One for the dame,",
                "And one for the little boy",
                "Who lives down the lane."
            ),
            hindiTitle = "भेड़ मेरी काली भेड़",
            teluguTitle = "Meme meme nalla gorre",
            tamilTitle = "மே மே கருப்பு ஆடு",
            kannadaTitle = "ಮ್ಮೆ ಮ್ಮೆ ಕಪ್ಪು ಕುರಿ",
            malayalamTitle = "മേ മേ കറുത്ത ആട്",
            hindiLines = listOf(
                "भेड़ मेरी काली भेड़,",
                "क्या है ऊन तुम्हारे?",
                "हाँ साहब, तीन थैले भर!",
                "एक मालिक, एक मालकिन,",
                "एक छोटे बच्चे के लिए!"
            ),
            teluguLines = listOf(
                "meme meme nalla gorre,",
                "nuvvu paadu unda?",
                "avunu saar, moodu sanchulu!",
                "okati master ki, okati dame ki,",
                "okati chinna pillaki!"
            ),
            tamilLines = listOf(
                "மே மே கருப்பு ஆடு,",
                "உனக்கு நூல் இருக்கிறதா?",
                "ஆம் ஐயா, மூன்று பை நிறை!",
                "ஒன்று எஜமானுக்கு, ஒன்று எஜமானி,",
                "ஒன்று சின்ன பையனுக்கு!"
            ),
            kannadaLines = listOf(
                "ಮ್ಮೆ ಮ್ಮೆ ಕಪ್ಪು ಕುರಿ,",
                "ನಿನಗೆ ಉಣ್ಣೆ ಇದೆಯ?",
                "ಹೌದು ಸಾರ್, ಮೂರು ಚೀಲ ತುಂಬ!",
                "ಒಂದು ಮಾಲಿಕ, ಒಂದು ಮಾಲಕಿನಿ,",
                "ಒಂದು ಚಿಕ್ಕ ಹುಡುಗ!"
            ),
            malayalamLines = listOf(
                "മേ മേ കറുത്ത ആട്,",
                "നിനക്ക് പഞ്ഞുണ്ടോ?",
                "അതെ സാർ, മൂന്ന് സഞ്ചി നിറ!",
                "ഒന്ന് adiyan, ഒന്ന് adiyathi,",
                "ഒന്ന് cheriya kutti!"
            )
        ),
        rhyme(
            id = 3,
            title = "Jack and Jill",
            category = RhymeCategory.STORY,
            illustration = "🏔️",
            lines = listOf(
                "Jack and Jill went up the hill",
                "To fetch a pail of water.",
                "Jack fell down and broke his crown,",
                "And Jill came tumbling after."
            ),
            hindiTitle = "जैक और जिल",
            teluguTitle = "Jack mariyu Jill",
            tamilTitle = "ஜாக் மற்றும் ஜில்",
            kannadaTitle = "Jack mattu Jill",
            malayalamTitle = "Jackum Jillum",
            hindiLines = listOf(
                "जैक और जिल पहाड़ पर गए,",
                "पानी लाने को।",
                "जैक गिरा और सिर फूटा,",
                "जिल भी पीछे गिर पड़ी!"
            ),
            teluguLines = listOf(
                "Jack mariyu Jill konda meeda poyaru,",
                "neellu techadaniki.",
                "Jack padipoyi talapattindi,",
                "Jill kuda ventane padindi!"
            ),
            tamilLines = listOf(
                "Jackum Jillum malai mele poyargal,",
                "thanni edukka.",
                "Jack vizhundhu thalai udaithaan,",
                "Jillum pinna vizhundhaal!"
            ),
            kannadaLines = listOf(
                "Jack mattu Jill betta mele hoda,",
                "neeru tandu.",
                "Jack biddu tale muriditu,",
                "Jill kooda biddu!"
            ),
            malayalamLines = listOf(
                "Jackum Jillum malayilekku poyi,",
                "vellam edukkan.",
                "Jack veenu thala murinj,",
                "Jillum pinne veenu!"
            )
        ),
        rhyme(
            id = 4,
            title = "Humpty Dumpty",
            category = RhymeCategory.STORY,
            illustration = "🥚",
            lines = listOf(
                "Humpty Dumpty sat on a wall,",
                "Humpty Dumpty had a great fall.",
                "All the king's horses and all the king's men",
                "Couldn't put Humpty together again."
            ),
            hindiTitle = "Humpty Dumpty",
            teluguTitle = "Humpty Dumpty",
            tamilTitle = "Humpty Dumpty",
            kannadaTitle = "Humpty Dumpty",
            malayalamTitle = "Humpty Dumpty",
            hindiLines = listOf(
                "Humpty Dumpty deewar par baitha,",
                "Humpty Dumpty gir pada!",
                "Raja ke saare ghode aur sipahi,",
                "Use jod na paaye phir se!"
            ),
            teluguLines = listOf(
                "Humpty Dumpty goda meeda kurchunnadu,",
                "Humpty Dumpty padipoyadu!",
                "Raju gurralu mariyu sainyamandu,",
                "malli kalupalekapoyaru!"
            ),
            tamilLines = listOf(
                "Humpty Dumpty mathil mele irundhaan,",
                "Humpty Dumpty vizhundhaan!",
                "Arasan kudiraiyum padaiyum,",
                "mellam kooda saeya mudiyaal!"
            ),
            kannadaLines = listOf(
                "Humpty Dumpty gode mele koothitu,",
                "Humpty Dumpty biddu!",
                "Raja kuduregalu mattu sainyavannu,",
                "matte serisalu aagalilla!"
            ),
            malayalamLines = listOf(
                "Humpty Dumpty mathilil irunnu,",
                "Humpty Dumpty veenu!",
                "Rajavinte kuthirakalum padayum,",
                "pinne kootti vekkamayirunnilla!"
            )
        ),
        rhyme(
            id = 5,
            title = "Row Row Row Your Boat",
            category = RhymeCategory.RHYME,
            illustration = "🚣",
            lines = listOf(
                "Row, row, row your boat,",
                "Gently down the stream.",
                "Merrily, merrily, merrily, merrily,",
                "Life is but a dream."
            ),
            hindiTitle = "नाव चलाओ नाव चलाओ",
            teluguTitle = "Paata paata paata",
            tamilTitle = "Paadi paadi paadi",
            kannadaTitle = "Hode hode hode",
            malayalamTitle = "Vandi vandi vandi",
            hindiLines = listOf(
                "नाव चलाओ, नाव चलाओ,",
                "धीरे नदी में बहो।",
                "खुशी से, खुशी से गाओ,",
                "ज़िंदगी एक सपना है!"
            ),
            teluguLines = listOf(
                "Paata paata paata,",
                "savvalo nadachi povu.",
                "santoshamga paadu,",
                "jeevitam oka swapnam!"
            ),
            tamilLines = listOf(
                "Paadi paadi paadi,",
                "aaruvalai mel irangi.",
                "Sanoshamaga paadu,",
                "vaazhkkai oru kanavu!"
            ),
            kannadaLines = listOf(
                "Hode hode hode,",
                "nadiyalli sali.",
                "Santoshadinda haadu,",
                "jeevana ondu swapna!"
            ),
            malayalamLines = listOf(
                "Vandi vandi vandi,",
                "aruviyil thazhe.",
                "Santhoshamode paadu,",
                "jeevitham oru swapnam!"
            )
        ),
        rhyme(
            id = 6,
            title = "Hickory Dickory Dock",
            category = RhymeCategory.RHYME,
            illustration = "🐭",
            lines = listOf(
                "Hickory dickory dock,",
                "The mouse ran up the clock.",
                "The clock struck one,",
                "The mouse ran down,",
                "Hickory dickory dock."
            ),
            hindiTitle = "हिकोरी डिकोरी डॉक",
            teluguTitle = "Hickory Dickory Dock",
            tamilTitle = "Hickory Dickory Dock",
            kannadaTitle = "Hickory Dickory Dock",
            malayalamTitle = "Hickory Dickory Dock",
            hindiLines = listOf(
                "हिकोरी डिकोरी डॉक,",
                "चूहा घड़ी पर दौड़ा।",
                "घड़ी ने एक बजाया,",
                "चूहा नीचे भागा!"
            ),
            teluguLines = listOf(
                "Hickory dickory dock,",
                "Eluka gadi meeda parigettindi.",
                "Gadi okati ayindi,",
                "Eluka kindaki parigettindi!"
            ),
            tamilLines = listOf(
                "Hickory dickory dock,",
                "Elu gadi mele odi.",
                "Gadi oru mani adithathu,",
                "Elu keezhai odi!"
            ),
            kannadaLines = listOf(
                "Hickory dickory dock,",
                "Elu gadi mele oditu.",
                "Gadi ondu bidditu,",
                "Elu kelage oditu!"
            ),
            malayalamLines = listOf(
                "Hickory dickory dock,",
                "Elu gadiyilekku odiy,",
                "Gadi oru mani adichu,",
                "Elu thazhott odiy!"
            )
        ),
        rhyme(
            id = 7,
            title = "Mary Had a Little Lamb",
            category = RhymeCategory.RHYME,
            illustration = "🐑",
            lines = listOf(
                "Mary had a little lamb,",
                "Little lamb, little lamb.",
                "Mary had a little lamb,",
                "Its fleece was white as snow.",
                "And everywhere that Mary went,",
                "Mary went, Mary went,",
                "Everywhere that Mary went,",
                "The lamb was sure to go."
            ),
            hindiTitle = "मेरी के पास एक भेड़ थी",
            teluguTitle = "Mary daggara oka gorre",
            tamilTitle = "Mary ku oru chinna aadu",
            kannadaTitle = "Maryge ondu chinna kuri",
            malayalamTitle = "Marykku oru cheriya aadu",
            hindiLines = listOf(
                "मेरी के पास एक छोटी भेड़,",
                "छोटी भेड़, छोटी भेड़!",
                "ऊन सफेद बर्फ जैसी,",
                "जहाँ मेरी जाती, भेड़ भी जाती!"
            ),
            teluguLines = listOf(
                "Mary daggara oka chinna gorre,",
                "chinna gorre, chinna gorre!",
                "Paadu telupu la undi,",
                "Mary ekkadiki vellina, gorre kuda vastundi!"
            ),
            tamilLines = listOf(
                "Mary ku oru chinna aadu,",
                "chinna aadu, chinna aadu!",
                "Paadu panchu pola,",
                "Mary enga ponaalum aadu kooda varum!"
            ),
            kannadaLines = listOf(
                "Maryge ondu chinna kuri,",
                "chinna kuri, chinna kuri!",
                "Paadu beli hannu,",
                "Mary ellige hodaaloo kuri kooda barutte!"
            ),
            malayalamLines = listOf(
                "Marykku oru cheriya aadu,",
                "cheriya aadu, cheriya aadu!",
                "Paadu vellam pole,",
                "Mary evide pokumbol aadum varum!"
            )
        ),
        rhyme(
            id = 8,
            title = "Old MacDonald",
            category = RhymeCategory.STORY,
            illustration = "🚜",
            lines = listOf(
                "Old MacDonald had a farm, E-I-E-I-O.",
                "And on that farm he had a cow, E-I-E-I-O.",
                "With a moo moo here and a moo moo there,",
                "Here a moo, there a moo, everywhere a moo moo.",
                "Old MacDonald had a farm, E-I-E-I-O."
            ),
            hindiTitle = "पुराने मैकडोनाल्ड",
            teluguTitle = "Old MacDonald",
            tamilTitle = "Old MacDonald",
            kannadaTitle = "Old MacDonald",
            malayalamTitle = "Old MacDonald",
            hindiLines = listOf(
                "पुराने मैकडोनाल्ड के पास खेत था,",
                "उस खेत में एक गाय थी!",
                "यहाँ म्यू, वहाँ म्यू,",
                "हर जगह म्यू म्यू!"
            ),
            teluguLines = listOf(
                "Old MacDonald ki oka polam undi,",
                "aa polam lo oka aavu undi!",
                "Ikkada moo, akkada moo,",
                "prati chota moo moo!"
            ),
            tamilLines = listOf(
                "Old MacDonald ku oru vayal,",
                "andha vayalil oru maadu!",
                "Inge moo, ange moo,",
                "engum moo moo!"
            ),
            kannadaLines = listOf(
                "Old MacDonald ge ondu thota,",
                "aa thotadalli ondu hasu!",
                "Illi moo, alli moo,",
                "ellalli moo moo!"
            ),
            malayalamLines = listOf(
                "Old MacDonald nte oru krishi,",
                "aa krishiyil oru pasu!",
                "Ivide moo, avide moo,",
                "engum moo moo!"
            )
        ),
        rhyme(
            id = 9,
            title = "The Wheels on the Bus",
            category = RhymeCategory.RHYME,
            illustration = "🚌",
            lines = listOf(
                "The wheels on the bus go round and round,",
                "Round and round, round and round.",
                "The wheels on the bus go round and round,",
                "All through the town.",
                "The wipers on the bus go swish swish swish,",
                "Swish swish swish, swish swish swish.",
                "The wipers on the bus go swish swish swish,",
                "All through the town."
            ),
            hindiTitle = "बस के पहिए",
            teluguTitle = "Bus chakralu",
            tamilTitle = "Bus chakkarangal",
            kannadaTitle = "Bus chakragalu",
            malayalamTitle = "Bus chakram",
            hindiLines = listOf(
                "बस के पहिए घूमते हैं,",
                "घूमते हैं, घूमते हैं!",
                "पूरे शहर में घूमते हैं।",
                "वाइपर स्विश स्विश करते हैं!"
            ),
            teluguLines = listOf(
                "Bus chakralu tirugutunnayi,",
                "tirugutunnayi, tirugutunnayi!",
                "pura pattanam lo tirugutunnayi.",
                "Wipers swish swish chestunnayi!"
            ),
            tamilLines = listOf(
                "Bus chakkarangal sutri sutri,",
                "sutri sutri, sutri sutri!",
                "oora muzhukka sutri sutri.",
                "Wipers swish swish!"
            ),
            kannadaLines = listOf(
                "Bus chakragalu tirugutte,",
                "tirugutte, tirugutte!",
                "oora ellaa tirugutte.",
                "Wipers swish swish!"
            ),
            malayalamLines = listOf(
                "Bus chakram thirum thirum,",
                "thirum thirum, thirum thirum!",
                "nagaram muzhuvan thirum.",
                "Wipers swish swish!"
            )
        ),
        rhyme(
            id = 10,
            title = "If You're Happy and You Know It",
            category = RhymeCategory.RHYME,
            illustration = "😊",
            lines = listOf(
                "If you're happy and you know it, clap your hands!",
                "If you're happy and you know it, clap your hands!",
                "If you're happy and you know it,",
                "Then your face will surely show it.",
                "If you're happy and you know it, clap your hands!"
            ),
            hindiTitle = "खुश हो तो ताली बजाओ",
            teluguTitle = "Santosham unte chetilu kottu",
            tamilTitle = "Sanosham na chethai adi",
            kannadaTitle = "Santosha iddare kai tattu",
            malayalamTitle = "Santhosham undo kai adi",
            hindiLines = listOf(
                "खुश हो तो ताली बजाओ!",
                "खुश हो तो ताली बजाओ!",
                "तुम्हारा चेहरा खुशी दिखाए,",
                "तो ताली बजाओ!"
            ),
            teluguLines = listOf(
                "Santosham unte chetilu kottu!",
                "Santosham unte chetilu kottu!",
                "Nee mukham santosham chupistundi,",
                "aithe chetilu kottu!"
            ),
            tamilLines = listOf(
                "Sanosham na kai adi!",
                "Sanosham na kai adi!",
                "Un mukam sanosham kaatum,",
                "appo kai adi!"
            ),
            kannadaLines = listOf(
                "Santosha iddare kai tattu!",
                "Santosha iddare kai tattu!",
                "Ninna mukha santoshavannu torisutte,",
                "aadre kai tattu!"
            ),
            malayalamLines = listOf(
                "Santhosham undo kai adi!",
                "Santhosham undo kai adi!",
                "Ninte mukham santhosham kaanikkum,",
                "enkil kai adi!"
            )
        ),
        rhyme(
            id = 11,
            title = "London Bridge Is Falling Down",
            category = RhymeCategory.RHYME,
            illustration = "🌉",
            lines = listOf(
                "London Bridge is falling down,",
                "Falling down, falling down.",
                "London Bridge is falling down,",
                "My fair lady.",
                "Build it up with iron bars,",
                "Iron bars, iron bars.",
                "Build it up with iron bars,",
                "My fair lady."
            ),
            hindiTitle = "लंदन ब्रिज गिर रहा है",
            teluguTitle = "London Bridge padipotundi",
            tamilTitle = "London Bridge vizhugirathu",
            kannadaTitle = "London Bridge biddu",
            malayalamTitle = "London Bridge veenu",
            hindiLines = listOf(
                "लंदन ब्रिज गिर रहा है,",
                "गिर रहा है, गिर रहा है!",
                "लोहे की सलाखों से बनाओ,",
                "हे सुंदर महिला!"
            ),
            teluguLines = listOf(
                "London Bridge padipotundi,",
                "padipotundi, padipotundi!",
                "Inumu bars tho kattandi,",
                "O sundara ammai!"
            ),
            tamilLines = listOf(
                "London Bridge vizhugirathu,",
                "vizhugirathu, vizhugirathu!",
                "Irumbu thadigalal kattu,",
                "O sundari!"
            ),
            kannadaLines = listOf(
                "London Bridge biddu,",
                "biddu, biddu!",
                "Kallina bars inda kattu,",
                "O sundari!"
            ),
            malayalamLines = listOf(
                "London Bridge veenu,",
                "veenu, veenu!",
                "Irumbu thadikal kondu kattu,",
                "O sundari!"
            )
        ),
        rhyme(
            id = 12,
            title = "Rain Rain Go Away",
            category = RhymeCategory.RHYME,
            illustration = "🌧️",
            lines = listOf(
                "Rain, rain, go away,",
                "Come again another day.",
                "Little children want to play,",
                "Rain, rain, go away."
            ),
            hindiTitle = "बारिश बारिश जाओ दूर",
            teluguTitle = "Vana vana poyivvu",
            tamilTitle = "Mazhai mazhai pogum",
            kannadaTitle = "Male male hogum",
            malayalamTitle = "Mazha mazha pogum",
            hindiLines = listOf(
                "बारिश बारिश जाओ दूर,",
                "कल फिर आना!",
                "छोटे बच्चे खेलना चाहते हैं,",
                "बारिश बारिश जाओ दूर!"
            ),
            teluguLines = listOf(
                "Vana vana poyivvu,",
                "repu malli ra!",
                "Chinnari pillalu adukovalani korutunnaru,",
                "vana vana poyivvu!"
            ),
            tamilLines = listOf(
                "Mazhai mazhai pogum,",
                "naalai varum!",
                "Chinna pasangal vilayaadum,",
                "mazhai mazhai pogum!"
            ),
            kannadaLines = listOf(
                "Male male hogum,",
                "naale baa!",
                "Chikka makkalu aadutare,",
                "male male hogum!"
            ),
            malayalamLines = listOf(
                "Mazha mazha pogum,",
                "nale varum!",
                "Cheriya kuttikal kalikkum,",
                "mazha mazha pogum!"
            )
        ),
        rhyme(
            id = 13,
            title = "Clap Your Hands",
            category = RhymeCategory.RHYME,
            illustration = "👏",
            lines = listOf(
                "Clap your hands, clap your hands,",
                "Listen to the music and clap your hands.",
                "Stamp your feet, stamp your feet,",
                "Listen to the music and stamp your feet.",
                "Turn around, turn around,",
                "Listen to the music and turn around."
            ),
            hindiTitle = "ताली बजाओ",
            teluguTitle = "Chetilu kottu",
            tamilTitle = "Kai adi",
            kannadaTitle = "Kai tattu",
            malayalamTitle = "Kai adi",
            hindiLines = listOf(
                "ताली बजाओ, ताली बजाओ!",
                "संगीत सुनो और ताली बजाओ।",
                "पैर पटकाओ, पैर पटकाओ!",
                "घूमो, घूमो, संगीत के साथ!"
            ),
            teluguLines = listOf(
                "Chetilu kottu, chetilu kottu!",
                "Sangeetam vini chetilu kottu.",
                "Paadala meeda kottu, paadala meeda kottu!",
                "Tirugu, tirugu, sangeetam tho!"
            ),
            tamilLines = listOf(
                "Kai adi, kai adi!",
                "Isai kettu kai adi.",
                "Kaalu adi, kaalu adi!",
                "Tirum, tirum, isaiyodu!"
            ),
            kannadaLines = listOf(
                "Kai tattu, kai tattu!",
                "Sangeeta keli kai tattu.",
                "Kaalu tattu, kaalu tattu!",
                "Tirugu, tirugu, sangeetadinda!"
            ),
            malayalamLines = listOf(
                "Kai adi, kai adi!",
                "Sangeetham kettu kai adi.",
                "Kal adi, kal adi!",
                "Thirum, thirum, sangeethamode!"
            )
        ),
        rhyme(
            id = 14,
            title = "The ABC Song",
            category = RhymeCategory.RHYME,
            illustration = "🔤",
            lines = listOf(
                "A B C D E F G,",
                "H I J K L M N O P,",
                "Q R S T U V,",
                "W X Y and Z.",
                "Now I know my ABCs,",
                "Next time won't you sing with me?"
            ),
            hindiTitle = "ABC गाना",
            teluguTitle = "ABC paata",
            tamilTitle = "ABC paatu",
            kannadaTitle = "ABC haadu",
            malayalamTitle = "ABC paattu",
            hindiLines = listOf(
                "A B C D E F G,",
                "H I J K L M N O P,",
                "Q R S T U V,",
                "W X Y और Z!",
                "अब मुझे ABC आ गए!"
            ),
            teluguLines = listOf(
                "A B C D E F G,",
                "H I J K L M N O P,",
                "Q R S T U V,",
                "W X Y mariyu Z!",
                "Ippudu naku ABC vachayi!"
            ),
            tamilLines = listOf(
                "A B C D E F G,",
                "H I J K L M N O P,",
                "Q R S T U V,",
                "W X Y and Z!",
                "Ippove enakku ABC theriyum!"
            ),
            kannadaLines = listOf(
                "A B C D E F G,",
                "H I J K L M N O P,",
                "Q R S T U V,",
                "W X Y and Z!",
                "Iga nanage ABC barutte!"
            ),
            malayalamLines = listOf(
                "A B C D E F G,",
                "H I J K L M N O P,",
                "Q R S T U V,",
                "W X Y and Z!",
                "Ippol enikku ABC ariyam!"
            )
        ),
        rhyme(
            id = 15,
            title = "Five Little Ducks",
            category = RhymeCategory.RHYME,
            illustration = "🦆",
            lines = listOf(
                "Five little ducks went out one day,",
                "Over the hill and far away.",
                "Mother duck said, \"Quack, quack, quack, quack,\"",
                "But only four little ducks came back.",
                "Four little ducks went out one day,",
                "Over the hill and far away.",
                "Mother duck said, \"Quack, quack, quack, quack,\"",
                "But only three little ducks came back."
            ),
            hindiTitle = "पाँच छोटे बत्तख",
            teluguTitle = "Aidu chinna bata chelu",
            tamilTitle = "Aindu chinna vathu",
            kannadaTitle = "Aidu chinna batte",
            malayalamTitle = "Anju cheriya thara",
            hindiLines = listOf(
                "पाँच छोटे बत्तख बाहर गए,",
                "पहाड़ के पार दूर!",
                "माँ बत्तख बोली क्वैक क्वैक,",
                "चार ही वापस आए!"
            ),
            teluguLines = listOf(
                "Aidu chinna bata chelu bayata poyayi,",
                "konda daati dooram!",
                "Talli bata quack quack annadi,",
                "nalaage matrame tirigi vachayi!"
            ),
            tamilLines = listOf(
                "Aindu chinna vathu veliye pona,",
                "malai thandi dooram!",
                "Amma vathu quack quack sonna,",
                "naalu mattum thirumbi vandha!"
            ),
            kannadaLines = listOf(
                "Aidu chinna batte horage hoda,",
                "betta daati doora!",
                "Tayi batte quack quack helida,",
                "nalku matra banda!"
            ),
            malayalamLines = listOf(
                "Anju cheriya thara purathu poyi,",
                "mala kadannu dooram!",
                "Amma thara quack quack paranj,",
                "nal matram thirichu vannu!"
            )
        )
    )

    fun byId(id: Int): Rhyme? = all.find { it.id == id }

    fun rhymeAtLevel(levelNumber: Int): Rhyme {
        val index = (levelNumber - 1).coerceAtLeast(0) % all.size
        return all[index]
    }

    private fun rhyme(
        id: Int,
        title: String,
        category: RhymeCategory,
        illustration: String,
        lines: List<String>,
        hindiTitle: String,
        teluguTitle: String,
        tamilTitle: String,
        kannadaTitle: String,
        malayalamTitle: String,
        hindiLines: List<String>,
        teluguLines: List<String>,
        tamilLines: List<String>,
        kannadaLines: List<String>,
        malayalamLines: List<String>
    ) = Rhyme(
        id = id,
        title = title,
        lines = lines,
        category = category,
        illustration = illustration,
        hindiTitle = hindiTitle,
        teluguTitle = teluguTitle,
        tamilTitle = tamilTitle,
        kannadaTitle = kannadaTitle,
        malayalamTitle = malayalamTitle,
        hindiLines = hindiLines,
        teluguLines = teluguLines,
        tamilLines = tamilLines,
        kannadaLines = kannadaLines,
        malayalamLines = malayalamLines
    )
}
