# 🗄 Database Schema (draft)

## Tables
- users → id, username, password_hash, created_at
- bank_accounts → id, user_id, bank_name, account_number_encrypted, ifsc_code, created_at
- cards → id, user_id, card_number_encrypted, expiry_date, cvv_encrypted, pin_encrypted, created_at

> Add Liquibase changelog info and update as you evolve.
