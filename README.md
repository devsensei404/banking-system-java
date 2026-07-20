# Banking System (Java)

A pure Java, console-based banking system built solo as an OOP revision exercise.
No tutorials open while coding, no external frameworks.

## Purpose

This project exists to revise core OOP concepts hands-on: abstraction, inheritance,
encapsulation, and polymorphism, applied through a realistic-ish domain (bank accounts).
It's intentionally scoped small so the focus stays on getting the fundamentals right.

## What this is

- An abstract `Account` hierarchy (`SavingsAccount`, `CurrentAccount` as subclasses),
  each enforcing its own withdrawal rules (minimum balance vs. overdraft limit)
- A `BankManager` class that owns all accounts, coordinates deposit, withdraw, and
  transfer operations, and is the sole translator between domain objects and
  display-ready messages
- An immutable `Transaction` record (type, amount, timestamp) with per-account,
  in-memory transaction history
- A console menu (loop + switch) for interaction, with no knowledge of the account
  or transaction internals

## What this deliberately is NOT (scoped out on purpose)

- **No custom exceptions.** Failure cases (insufficient funds, invalid account,
  invalid amount) are handled via return values and enums, not exceptions.
  Exception handling is the focus of a later project (Contact Book, file I/O).
- **No file persistence.** Everything lives in memory and resets on program exit.
- **No Spring or database.** Pure Java only, to keep the focus on OOP fundamentals
  rather than framework mechanics.

## Known limitations

- The console menu does not validate non-numeric input at prompts expecting a
  number (e.g. typing a letter at the menu choice prompt). Since exception
  handling is out of scope for this project, this can crash the program.
- Transfers do not currently support overriding a source account's minimum
  balance rule the way standalone withdrawals do.

## Status

Core functionality complete: account creation, deposit, withdraw (with minimum
balance / overdraft enforcement), transfer, and transaction history.

## Tech

- Java (no external dependencies)