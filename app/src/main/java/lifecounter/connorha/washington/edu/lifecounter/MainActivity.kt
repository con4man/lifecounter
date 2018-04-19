package lifecounter.connorha.washington.edu.lifecounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val lifePoints: IntArray = intArrayOf(20, 20, 20, 20)

    fun onClick(v: View) {
        when (v.id) {
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
                "addFive" -> add5(player)
                "addOne" -> add1(player)
                "subOne" -> sub1(player)
                "subFive" -> sub5(player)
            }
        }
        updateLifePointDisplay(player)
    }

    private fun updateLifePointDisplay(player: Int) {
        when (player) {
            1 -> player1Text.text = "Test"
            2 -> player2Text.text = "P2: $lifePoints[1]"
            3 -> player3Text.text = "P3: $lifePoints[2]"
            4 -> player4Text.text = "P4: $lifePoints[3]"
        }
    }

    private fun gameIsOver() : Boolean {
        return (lifePoints.contains(0) || lifePoints.contains(-1) || lifePoints.contains(-2) || lifePoints.contains(-3) || lifePoints.contains(-4))
    }

    private fun add5(player :Int) {
        val playerPositionInArray = player -1
        val currentLifePoints = lifePoints.get(playerPositionInArray)
        lifePoints.set(playerPositionInArray, currentLifePoints + 5)
    }

    private fun add1(player :Int) {
        val playerPositionInArray = player -1
        val currentLifePoints = lifePoints.get(playerPositionInArray)
        lifePoints.set(playerPositionInArray, currentLifePoints + 1)
    }

    private fun sub1(player :Int) {
        val playerPositionInArray = player -1
        val currentLifePoints = lifePoints.get(playerPositionInArray)
        lifePoints.set(playerPositionInArray, currentLifePoints - 1)
    }

    private fun sub5(player :Int) {
        val playerPositionInArray = player -1
        val currentLifePoints = lifePoints.get(playerPositionInArray)
        lifePoints.set(playerPositionInArray, currentLifePoints - 5)
    }



}
