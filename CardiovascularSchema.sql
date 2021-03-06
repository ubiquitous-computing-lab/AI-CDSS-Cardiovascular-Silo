USE [master]
GO
/****** Object:  Database [Cardiovascular]    Script Date: 11/14/2019 3:43:57 PM ******/
CREATE DATABASE [Cardiovascular]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Cardiovascular', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\Cardiovascular.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Cardiovascular_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\Cardiovascular_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Cardiovascular] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Cardiovascular].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Cardiovascular] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Cardiovascular] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Cardiovascular] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Cardiovascular] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Cardiovascular] SET ARITHABORT OFF 
GO
ALTER DATABASE [Cardiovascular] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Cardiovascular] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [Cardiovascular] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Cardiovascular] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Cardiovascular] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Cardiovascular] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Cardiovascular] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Cardiovascular] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Cardiovascular] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Cardiovascular] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Cardiovascular] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Cardiovascular] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Cardiovascular] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Cardiovascular] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Cardiovascular] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Cardiovascular] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Cardiovascular] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Cardiovascular] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Cardiovascular] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Cardiovascular] SET  MULTI_USER 
GO
ALTER DATABASE [Cardiovascular] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Cardiovascular] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Cardiovascular] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Cardiovascular] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [Cardiovascular]
GO
/****** Object:  Table [dbo].[tblPatient]    Script Date: 11/14/2019 3:43:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblPatient](
	[PatientID] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[PatientMRNNo] [varchar](50) NULL,
	[PatientName] [varchar](100) NULL,
	[DateOfBirth] [date] NULL,
	[Age] [int] NULL,
	[Gender] [varchar](50) NULL,
	[SymptomsAndSigns] [int] NULL,
	[ClinicalHistory] [int] NULL,
	[PhysicalExam] [int] NULL,
	[ECG] [int] NULL,
	[NTproBNP] [float] NULL,
	[BNP] [float] NULL,
	[LVEF] [float] NULL,
	[LAVI] [float] NULL,
	[LVMI] [float] NULL,
	[Ee] [float] NULL,
	[eSeptal] [float] NULL,
	[LongitudinalStrain] [float] NULL,
	[TRV] [float] NULL,
	[EncounterDate] [date] NULL,
 CONSTRAINT [PK_tblPatient] PRIMARY KEY CLUSTERED 
(
	[PatientID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblPatientClinicalHistory]    Script Date: 11/14/2019 3:43:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPatientClinicalHistory](
	[PatientClinicalHistoryID] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[PatientID] [numeric](18, 0) NULL,
	[CAD] [int] NULL,
	[ArterialHypertension] [int] NULL,
	[ExpositionToCardiotoxic] [int] NULL,
	[UseOfDiuretics] [int] NULL,
	[OrthopnoeaParoxysmal] [int] NULL,
	[EncounterDate] [date] NULL,
 CONSTRAINT [PK_tblPatientClinicalHistory] PRIMARY KEY CLUSTERED 
(
	[PatientClinicalHistoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblPatientPhysicalExam]    Script Date: 11/14/2019 3:43:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPatientPhysicalExam](
	[PatientPhysicalExamID] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[PatientID] [numeric](18, 0) NULL,
	[Rales] [int] NULL,
	[BilateralAnkleEdema] [int] NULL,
	[HeartMurmur] [int] NULL,
	[JugularVenousDilatation] [int] NULL,
	[ElevatedJVP] [int] NULL,
	[S3] [int] NULL,
	[NocternalCough] [int] NULL,
	[LaterallyDisplacedApical] [int] NULL,
	[Impulse] [int] NULL,
	[EncounterDate] [date] NULL,
 CONSTRAINT [PK_tblPatientPhysicalExam] PRIMARY KEY CLUSTERED 
(
	[PatientPhysicalExamID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblPatientSymptoms]    Script Date: 11/14/2019 3:43:57 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblPatientSymptoms](
	[PatientSymptomID] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[PatientID] [numeric](18, 0) NULL,
	[Breathlessness] [int] NULL,
	[Orthopnoea] [int] NULL,
	[PND] [int] NULL,
	[ReducedExerciseTolerance] [int] NULL,
	[Fatigue] [int] NULL,
	[Tiredness] [int] NULL,
	[AnkleSwelling] [int] NULL,
	[EncounterDate] [date] NULL
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[tblPatientClinicalHistory]  WITH CHECK ADD  CONSTRAINT [FK_nqxq9xc382rrfsbctfv8lqpxv] FOREIGN KEY([PatientID])
REFERENCES [dbo].[tblPatient] ([PatientID])
GO
ALTER TABLE [dbo].[tblPatientClinicalHistory] CHECK CONSTRAINT [FK_nqxq9xc382rrfsbctfv8lqpxv]
GO
ALTER TABLE [dbo].[tblPatientPhysicalExam]  WITH CHECK ADD  CONSTRAINT [FK_icca7o3nlb1es29l4menqbal9] FOREIGN KEY([PatientID])
REFERENCES [dbo].[tblPatient] ([PatientID])
GO
ALTER TABLE [dbo].[tblPatientPhysicalExam] CHECK CONSTRAINT [FK_icca7o3nlb1es29l4menqbal9]
GO
ALTER TABLE [dbo].[tblPatientSymptoms]  WITH CHECK ADD  CONSTRAINT [FK_7v9qkoamuht6mx8nwh2jbi7dy] FOREIGN KEY([PatientID])
REFERENCES [dbo].[tblPatient] ([PatientID])
GO
ALTER TABLE [dbo].[tblPatientSymptoms] CHECK CONSTRAINT [FK_7v9qkoamuht6mx8nwh2jbi7dy]
GO
USE [master]
GO
ALTER DATABASE [Cardiovascular] SET  READ_WRITE 
GO
