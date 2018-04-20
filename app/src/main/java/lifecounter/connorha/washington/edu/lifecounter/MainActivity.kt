package lifecounter.connorha.washington.edu.lifecounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val lifePoints: IntArray = intArrayOf(20, 20, 20, 20)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setClickListeners()
    }

    private fun setClickListeners() {
        player1Add5.setOnClickListener(this)
        player1Add1.setOnClickListener(this)
        player1Sub1.setOnClickListener(this)
        player1Sub5.setOnClickListener(this)

        player2Add5.setOnClickListener(this)
        player2Add1.setOnClickListener(this)
        player2Sub1.setOnClickListener(this)
        player2Sub5.setOnClickListener(this)

        player3Add5.setOnClickListener(this)
        player3Add1.setOnClickListener(this)
        player3Sub1.setOnClickListener(this)
        player3Sub5.setOnClickListener(this)

        player4Add5.setOnClickListener(this)
        player4Add1.setOnClickListener(this)
        player4Sub1.setOnClickListener(this)
        player4Sub5.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            player1Add5.id -> updateLifePoints(1, "addFive")
            player1Add1.id -> updateLifePoints(1, "addOne")
            player1Sub1.id -> updateLifePoints(1, "subOne")
            player1Sub5.id -> updateLifePoints(1, "subFive")

            player2Add5.id -> updateLifePoints(2, "addFive")
            player2Add1.id -> updateLifePoints(2, "addOne")
            player2Sub1.id -> updateLifePoints(2, "subOne")
            player2Sub5.id -> updateLifePoints(2, "subFive")

            player3Add5.id -> updateLifePoints(3, "addFive")
            player3Add1.id -> updateLifePoints(3, "addOne")
            player3Sub1.id -> updateLifePoints(3, "subOne")
            player3Sub5.id -> updateLifePoints(3, "subFive")

            player4Add5.id -> updateLifePoints(4, "addFive")
            player4Add1.id -> updateLifePoints(4, "addOne")
            player4Sub1.id -> updateLifePoints(4, "subOne")
            player4Sub5.id -> updateLifePoints(4, "subFive")
        }
    }

    private fun updateLifePoints(player: Int, updateType: String) {
        if (!gameIsOver()) {
            when (updateType) {
                "addFive" -> updateLifePointsArray(player, 5)
                "addOne" -> updateLifePointsArray(player, 1)
                "subOne" -> updateLifePointsArray(player, -1)
                "subFive" -> updateLifePointsArray(player, -5)
            }
        } else {
            resetCounter()
            updateAllPlayersLifePoints()
        }
        updateLifePointsDisplay(player)
        if (gameIsOver()) {
            showLoserDisplay()
        }
    }

    private fun updateLifePointsDisplay(player: Int) {
        val playerLifePoints = lifePoints[player - 1]
        val playerDisplayString = "P$player: $playerLifePoints"
        when (player) {
            1 -> player1Text.text = (playerDisplayString)
            2 -> player2Text.text = (playerDisplayString)
            3 -> player3Text.text = (playerDisplayString)
            4 -> player4Text.text = (playerDisplayString)
        }
    }

    private fun gameIsOver() : Boolean {
        return lifePoints.contains(0)
    }

    private fun updateLifePointsArray(player :Int, changeValue :Int) {
        lifePoints[player - 1] = lifePoints[player - 1] + changeValue
        if (lifePoints[player - 1] < 0) {
            lifePoints[player - 1] = 0
        }
    }

    private fun showLoserDisplay() {
        val losingPlayer = lifePoints.indexOf(0) + 1
        val losingPlayerString = "Player $losingPlayer LOSES!"
        losingPlayerText.text = losingPlayerString
    }

    private fun resetCounter() {
        for (i in 0..3) {
            lifePoints[i] = 20
        }
        losingPlayerText.text = ""
    }

    private fun updateAllPlayersLifePoints() {
        for (i in 1..4) {
            updateLifePointsDisplay(i)
        }
    }

}
