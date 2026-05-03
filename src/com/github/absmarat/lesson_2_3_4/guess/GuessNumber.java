package com.github.absmarat.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    static final int MAX_ATTEMPTS = 10;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 100;

    private Player p1;
    private Player p2;
    private Player p3;
    private int hiddenNumber;

    public GuessNumber(Player p1, Player p2, Player p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public void start() throws InterruptedException {
        Player[] players = {p1, p2, p3};
        Player[] shuffledPlayers = shufflePlayers(players);
        resetWins(shuffledPlayers);

        System.out.println("\nИгра началась! " +
                "У каждого игрока по " + MAX_ATTEMPTS + " попыток в трёх раундах.");

        Scanner console = new Scanner(System.in);
        Random random = new Random();

        for (int round = 1; round <= 3; round++) {
            System.out.println("\nЧисло загадано! \nРАУНД " + round);
            hiddenNumber = random.nextInt(MIN_NUMBER, MAX_NUMBER + 1);

            resetGuesses(shuffledPlayers);

            loopLabel:
            for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
                System.out.println("Попытка " + attempt);
                for (Player player : shuffledPlayers) {
                    if (isGuessed(player, console)) break loopLabel;
                    checkAttemptCount(attempt, player.getName());
                }
            }
            displayPlayerGuesses(shuffledPlayers);
        }
        determineWinner(shuffledPlayers);
    }

    private Player[] shufflePlayers(Player[] players) throws InterruptedException {
        Random rnd = new Random();
        int n = players.length;

        for (int i = n - 1; i > 0; i--) {
            int random = rnd.nextInt(i + 1);
            Player temp = players[i];
            players[i] = players[random];
            players[random] = temp;
        }
        displayNames(players);
        return players;
    }

    private void displayNames(Player[] players) throws InterruptedException {
        System.out.print("\nРезультат жеребьёвки:  ");
        for (Player player : players) {
            animateSpinner();
            System.out.print(player.getName() + "  ");
        }
    }

    private void animateSpinner() throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};

        for (int i = 0; i < 6; i++) {
            for (char element : spins) {
                System.out.print("\b" + element);
                Thread.sleep(100);
            }
        }
        System.out.print("\b");
    }

    private void resetWins(Player[] players) {
        for (Player player : players) {
            player.resetPlayerWins();
        }
    }

    private void resetGuesses(Player[] players) {
        for (Player player : players) {
            player.reset();
        }
    }

    private boolean isGuessed(Player player, Scanner console) {
        System.out.print(player.getName() + ", введи предполагаемое число: ");

        while (true) {
            try {
                int guess = inputGuess(console);
                player.setGuess(guess);
                player.recordGuess(guess);

                if (isGuessCorrect(player)) {
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

    private boolean isGuessCorrect(Player player) {
        int guess = player.getGuess();
        if (guess == hiddenNumber) {
            System.out.println(player.getName() + " угадал(-а) с " + player.getAttempts() + "-й попытки!");
            int wins = player.getWins();
            player.setWins(wins + 1);
            return true;
        }

        String comparison = guess < hiddenNumber ? " меньше " : " больше ";
        System.out.println("   Число " + player.getGuess() + comparison + " загаданного!");
        return false;
    }

    private void checkAttemptCount(int attempt, String name) {
        if (attempt >= MAX_ATTEMPTS) {
            System.out.println("У игрока " + name + " закончились попытки!");
        }
    }

    private void displayPlayerGuesses(Player[] players) {
        System.out.println("Список чисел названных игроками!");
        for (Player player : players) {
            System.out.print(player.getName() + ": ");
            int[] playerGuesses = player.receiveGuesses();
            for (int guess : playerGuesses) {
                System.out.print(guess + " ");
            }
            System.out.println();
        }
    }

    private void determineWinner(Player[] players) {
        System.out.println("\n == РЕЗУЛЬТАТ ИГРЫ == ");
        int maxWins = determineMaxWins(players);
        int winnerCount = countWinners(players, maxWins);
        Player[] winners = findWinnersByMaxWins(players, maxWins, winnerCount);
        displayResult(winners, maxWins);
    }

    private int determineMaxWins(Player[] players) {
        int maxWins = 0;
        for (Player player : players)
            if (player.getWins() > maxWins) {
                maxWins = player.getWins();
            }
        return maxWins;
    }

    private int countWinners(Player[] players, int maxWins) {
        int winnerCount = 0;
        for (Player player : players) {
            if (player.getWins() == maxWins) {
                winnerCount++;
            }
        }
        return winnerCount;
    }

    private Player[] findWinnersByMaxWins(Player[] players, int maxWin, int winnerCount) {
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
            System.out.println("Победил(-а) игрок " + winner.getName() +
                    "! Кол-во побед: " + winner.getWins());
        } else {
            System.out.println("Ничья между игроками: ");
            for (Player winner : winners) {
                System.out.println(winner.getName() + " (кол-во побед: " + winner.getWins() + ")");
            }
        }
    }
}




