# Banking System (Java)

A pure Java, console-based banking system built solo as an OOP revision exercise —
no tutorials open while coding, no external frameworks.

## Purpose

This project exists to revise core OOP concepts hands-on: abstraction, inheritance,
encapsulation, and polymorphism, applied through a realistic-ish domain (bank accounts).
It's intentionally scoped small so the focus stays on getting the fundamentals right.

## What this is

- An `Account` hierarchy (`SavingsAccount`, `CurrentAccount` as subclasses)
- A `Bank` / `BankManager` class to manage accounts, deposits, withdrawals, and transfers
- In-memory transaction history per account
- A console menu (loop + switch) for interaction

## What this deliberately is NOT (scoped out on purpose)

- **No custom exceptions** — failure cases (insufficient funds, invalid account, etc.)
  are handled via return values / boolean checks for now. Exception handling is the
  focus of a later project (Contact Book, file I/O + exceptions).
- **No file persistence** — everything lives in memory and resets on program exit.
- **No Spring / database** — pure Java only, to keep the focus on OOP fundamentals
  rather than framework mechanics.

## Status

In development — built incrementally, commit history reflects
the design till date.

## Tech

- Java (no external dependencies)
