CREATE DATABASE [LibDB]

USE [LibDB]
GO

/****** Object:  Table [dbo].[StudentBook]    Script Date: 1/18/2018 10:00:58 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[StudentBook](
	[StudentId] [int] NOT NULL,
	[CallNumber] [int] NOT NULL,
	[IssueDate] [varchar](50) NULL,
	[DueDate] [varchar](50) NULL,
	[IssueStatus] [varchar](50) NULL,
	[CheckoutDate] [varchar](50) NULL,
 CONSTRAINT [PK_StudentBook] PRIMARY KEY CLUSTERED 
(
	[StudentId] ASC,
	[CallNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[StudentBook]  WITH CHECK ADD  CONSTRAINT [FK_StudentBook_Book] FOREIGN KEY([CallNumber])
REFERENCES [dbo].[Book] ([CallNumber])
GO

ALTER TABLE [dbo].[StudentBook] CHECK CONSTRAINT [FK_StudentBook_Book]
GO

ALTER TABLE [dbo].[StudentBook]  WITH CHECK ADD  CONSTRAINT [FK_StudentBook_Student] FOREIGN KEY([StudentId])
REFERENCES [dbo].[Student] ([StudentId])
GO

ALTER TABLE [dbo].[StudentBook] CHECK CONSTRAINT [FK_StudentBook_Student]
GO


