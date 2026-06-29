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
        hindiLines: List<String>,
        teluguLines: List<String>,
        tamilTitle: String? = null,
        tamilLines: List<String>? = null
    ) = Rhyme(
        id = id,
        title = title,
        lines = lines,
        category = category,
        illustration = illustration,
        hindiTitle = hindiTitle,
        teluguTitle = teluguTitle,
        tamilTitle = tamilTitle,
        hindiLines = hindiLines,
        teluguLines = teluguLines,
        tamilLines = tamilLines
    )
}
