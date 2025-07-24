--
-- Compliance Table
--

CREATE TABLE IF NOT EXISTS "compliance" (
    id BIGSERIAL PRIMARY KEY,
    document_type VARCHAR(100) NOT NULL,
    document_url TEXT NOT NULL,
    end_date DATE,
    identity_number VARCHAR(100) NOT NULL,
    identity_type VARCHAR(100) NOT NULL,
    remarks TEXT,
    start_date DATE,
    status VARCHAR(50) NOT NULL,
    submission_date DATE NOT NULL,
    updated_date TIMESTAMP(6),
    verified_by VARCHAR(100),
    verified_date DATE,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "user"(id),
    CHECK (status IN ('PENDING', 'VERIFIED', 'REJECTED'))
);



INSERT INTO "compliance" VALUES (1, 'PDF', 'https://example.com/documents/aadhar.pdf', NULL, '1234-5678-9101', 'Aadhar', 'Initial submission for KYC verification.', '2025-07-01', 'PENDING', '2025-07-07', '2025-07-18 07:03:04.414831', 'admin_user', '2025-07-08', 1);
INSERT INTO "compliance" VALUES (2, 'PDF', 'https://example.com/documents/aadhar.pdf', NULL, '1234-5678-9101', 'Aadhar', 'Initial submission for KYC verification.', '2025-07-01', 'PENDING', '2025-07-07', '2025-07-18 08:21:36.591121', 'admin_user', '2025-07-08', 1);
INSERT INTO "compliance" VALUES (3, 'PDF', 'https://example.com/documents/aadhar.pdf', NULL, '1234-5678-9101', 'Aadhar', 'Initial submission for KYC verification.', NULL, 'PENDING', '2025-07-07', '2025-07-18 08:38:02.076502', 'admin_user', '2025-07-08', 1);
INSERT INTO "compliance" VALUES (4, 'PDF', 'https://example.com/documents/aadhar.pdf', NULL, '1234-5678-9101', 'Aadhar', 'Initial submission for KYC verification.', NULL, 'PENDING', '2025-07-07', '2025-07-18 08:41:10.185628', 'admin_user', '2025-07-08', 1);
INSERT INTO "compliance" VALUES (5, 'PDF', 'https://example.com/documents/aadhar.pdf', NULL, '1234-5678-9101', 'Aadhar', 'Initial submission for KYC verification.', NULL, 'PENDING', '2025-07-07', '2025-07-18 12:32:50.698559', 'admin_user', '2025-07-08', 1);
INSERT INTO "compliance" VALUES (6, 'PDF', 'https://example.com/documents/aadhar.pdf', NULL, '1234-5678-9101', 'Aadhar', 'Initial submission for KYC verification.', NULL, 'PENDING', '2025-07-07', '2025-07-18 13:32:32.618681', 'admin_user', '2025-07-08', 1);
