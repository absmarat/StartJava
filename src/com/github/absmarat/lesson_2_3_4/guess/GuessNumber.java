package com.github.absmarat.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    static final int MAX_ATTEMPTS = 10;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 100;
    static final int ROUNDS = 3;
    static final int SPINER_CYCLES = 6;

    private Player[] players;

    public GuessNumber(Player[] players) {
        this.players = players;
    }

    public void start() throws InterruptedException {
        shufflePlayers();
        initGame();

        System.out.println("\nИгра началась! " +
                "У каждого игрока по " + MAX_ATTEMPTS + " попыток в трёх раундах.");

        Scanner console = new Scanner(System.in);
        Random random = new Random();

        for (int i = 1; i <= ROUNDS; i++) {
            System.out.println("\nЧисло загадано! \nРАУНД " + i);
            playRound(console, random);
            displayPlayerGuesses();
        }
        determineWinner();
    }

    private void shufflePlayers() throws InterruptedException {
        Random rnd = new Random();
        int n = players.length;

        for (int i = n - 1; i > 0; i--) {
            int random = rnd.nextInt(i + 1);
            Player temp = players[i];
            players[i] = players[random];
            players[random] = temp;
        }
        castLots();
    }

    private void castLots() throws InterruptedException {
        System.out.print("\nРезультат жеребьёвки:  ");
        animateSpinner();
        for (Player player : players) {
            System.out.print(player.getName() + "  ");
        }
    }

    private void animateSpinner() throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};
        for (int i = 0; i < SPINER_CYCLES; i++) {
            for (char spin : spins) {
                System.out.print("\b" + spin);
                Thread.sleep(100);
            }
        }
        System.out.print("\b");
    }

    private void initGame() {
        for (Player player : players) {
            player.resetPlayerWins();
        }
    }

    private boolean playRound(Scanner console, Random random) {
        int hiddenNumber = random.nextInt(MIN_NUMBER, MAX_NUMBER + 1);
        initRound();

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.println("ПОПЫТКА " + attempt);
            for (Player player : players) {
                if (makeGuess(player, console, hiddenNumber)) {
                    return true;
                }
                hasAttempt(attempt, player.getName());
            }
        }
        return false;
    }

    private void initRound() {
        for (Player player : players) {
            player.reset();
        }
    }

    private boolean makeGuess(Player player, Scanner console, int hiddenNumber) {
        System.out.print(player.getName() + ", введи предполагаемое число: ");

        while (true) {
            try {
                int guess = inputGuess(console);
                player.addGuess(guess);

                if (isGuessed(player, hiddenNumber)) {
                    return true;
                }
                return false;
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage() + " Попробуй ещё раз: ");
            }
        }
    }

    private int inputGuess(Scanner console) {
        while (!console.hasNextInt()) {
            System.out.print("Ошибка! Введите целое число: ");
            console.next();
        }
        return console.nextInt();
    }

    private boolean isGuessed(Player player, int hiddenNumber) {
        int guess = player.getGuess();
        if (guess == hiddenNumber) {
            System.out.println(player.getName() + " угадал(-а) с " + player.getAttempts() + "-й попытки!");
            player.addWin();
            return true;
        }

        String comparison = guess < hiddenNumber ? " меньше " : " больше ";
        System.out.println("   Число " + guess + comparison + " загаданного!");
        return false;
    }

    private void hasAttempt(int attempt, String name) {
        if (attempt >= MAX_ATTEMPTS) {
            System.out.println("У игрока " + name + " закончились попытки!");
        }
    }

    private void displayPlayerGuesses() {
        System.out.println("Список чисел, названных игроками!");
        for (Player player : players) {
            System.out.print("  " + player.getName() + ": ");
            int[] playerGuesses = player.receiveGuesses();
            for (int guess : playerGuesses) {
                System.out.print(guess + " ");
            }
            System.out.println();
        }
    }

    private void determineWinner() {
        System.out.println("\n == РЕЗУЛЬТАТ ИГРЫ == ");
        int maxWins = determineMaxWins();
        int winnerCount = countWinners(maxWins);
        Player[] winners = findWinnersByMaxWins(maxWins, winnerCount);
        displayResult(winners, maxWins);
    }

    private int determineMaxWins() {
        int maxWins = 0;
        for (Player player : players)
            if (player.getWins() > maxWins) {
                maxWins = player.getWins();
            }
        return maxWins;
    }

    private int countWinners(int maxWins) {
        int winnerCount = 0;
        for (Player player : players) {
            if (player.getWins() == maxWins) {
                winnerCount++;
            }
        }
        return winnerCount;
    }

    private Player[] findWinnersByMaxWins(int maxWin, int winnerCount) {
        Player[] winners = new Player[winnerCount];
        int index = 0;
        for (Player player : players) {
            if (player.getWins() == maxWin) {
                winners[index++] = player;
            }
        }
        return winners;
    }

    private void displayResult(Player[] winners, int maxWins) {
        if (maxWins == 0) {
            System.out.println("Никто не выиграл!");
        } else if (winners.length == 1) {
            Player winner = winners[0];
            System.out.println("Победил(-а) " + winner.getName() +
                    "! Кол-во побед: " + winner.getWins());
        } else {
            System.out.println("Ничья между игроками: ");
            for (Player winner : winners) {
                System.out.println(winner.getName() + " (кол-во побед: " + winner.getWins() + ")");
            }
        }
    }
}




