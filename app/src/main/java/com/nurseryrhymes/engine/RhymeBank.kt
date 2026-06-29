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
        lines: List<String>
    ) = Rhyme(id, title, lines, category, illustration)
}
