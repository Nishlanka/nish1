package com.cicl.system.CICLIT_SYSTEM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;
import com.cicl.system.NonMotor.DBConnection;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;

public class HR_Emp_Personal_Details_Sub extends HR_Emp_Personal_Details {
	private String username;
	private int user_level;
	private String branch_code;
	private String branch_name;
	private String epf_no;
	int risultato = -1;
	int rowaffected = 0;

	public HR_Emp_Personal_Details_Sub() {

		super();

		comboBox_mart_status.setNullSelectionAllowed(false);
		// textField_epf.setEnabled(false);

		textField_pcity.setInputPrompt("City");
		textField_pstate.setInputPrompt("State");
		textField_pzip.setInputPrompt("ZIP Code");
		textField_tcity.setInputPrompt("City");
		textField_tstate.setInputPrompt("State");
		textField_tzip.setInputPrompt("ZIP Code");
		textField_email.setInputPrompt("example@gmail.com");
		textField_emg1_city.setInputPrompt("City");
		textField_emg1_state.setInputPrompt("State");
		textField_emg1_zip.setInputPrompt("ZIP Code");
		textField_emg2_city1.setInputPrompt("City");
		textField_emg2_state.setInputPrompt("State");
		textField_emg2_zip.setInputPrompt("ZIP Code");

		textField_alterPhone.setMaxLength(10);
		textField_homePhone.setMaxLength(10);
		textField_spousePhone.setMaxLength(10);
		textField_emg1_hpno.setMaxLength(10);
		textField_emg1_hpno.setMaxLength(10);
		textField_emg1_alterpNo.setMaxLength(10);
		textField_emg2_hPno.setMaxLength(10);
		textField_spousePhone1.setMaxLength(10);
		textField_w_f_Pno.setMaxLength(10);
		textField__m_pno.setMaxLength(10);
		textField_sib3_wpno.setMaxLength(10);
		textField4_sib3_wpno.setMaxLength(10);
		textField_wpno_s1.setMaxLength(10);
		textField_sib2_wpno.setMaxLength(10);

		textField_alterPhone.addValidator(new RegexpValidator("^[0-9]{10}$", "Invalid Contact No"));
		textField_alterPhone.addBlurListener(new BlurListener() {

			@Override
			public void blur(BlurEvent event) {
				// TODO Auto-generated method stub
				if (textField_alterPhone.isValid() == false) {
					textField_alterPhone.setValidationVisible(true);
				} else if (textField_alterPhone.isValid() == true) {
					textField_alterPhone.setValidationVisible(false);
				}

			}
		});

		textField_homePhone.addValidator(new RegexpValidator("^[0-9]{10}$", "Invalid Contact No"));
		textField_homePhone.addBlurListener(new BlurListener() {

			@Override
			public void blur(BlurEvent event) {
				// TODO Auto-generated method stub
				if (textField_homePhone.isValid() == false) {
					textField_homePhone.setValidationVisible(true);
				} else if (textField_homePhone.isValid() == true) {
					textField_homePhone.setValidationVisible(false);
				}

			}
		});

		textField_spousePhone.addValidator(new RegexpValidator("^[0-9]{10}$", "Invalid Contact No"));
		textField_spousePhone.addBlurListener(new BlurListener() {

			@Override
			public void blur(BlurEvent event) {
				// TODO Auto-generated method stub
				if (textField_spousePhone.isValid() == false) {
					textField_spousePhone.setValidationVisible(true);
				} else if (textField_spousePhone.isValid() == true) {
					textField_spousePhone.setValidationVisible(false);
				}

			}
		});

		textField_email.addValidator(new RegexpValidator("^(.+)@(.+)$", "Invalid email"));
		textField_email.addBlurListener(new BlurListener() {

			@Override
			public void blur(BlurEvent event) {
				// TODO Auto-generated method stub
				if (textField_email.isValid() == false) {
					textField_email.setValidationVisible(true);
				} else if (textField_email.isValid() == true) {
					textField_email.setValidationVisible(false);
				}

			}
		});

		textField_w_f_Pno.addValidator(new RegexpValidator("^[0-9]{10}$", "Invalid Father's work Phone No"));
		textField_w_f_Pno.addBlurListener(new BlurListener() {

			@Override
			public void blur(BlurEvent event) {
				// TODO Auto-generated method stub
				if (textField_w_f_Pno.isValid() == false) {
					textField_w_f_Pno.setValidationVisible(true);
				} else if (textField_w_f_Pno.isValid() == true) {
					textField_w_f_Pno.setValidationVisible(false);
				}

			}
		});

		textField__m_pno.addValidator(new RegexpValidator("^[0-9]{10}$", "Invalid Mother's work Phone No"));
		textField__m_pno.addBlurListener(new BlurListener() {

			@Override
			public void blur(BlurEvent event) {
				// TODO Auto-generated method stub
				if (textField__m_pno.isValid() == false) {
					textField__m_pno.setValidationVisible(true);
				} else if (textField__m_pno.isValid() == true) {
					textField__m_pno.setValidationVisible(false);
				}

			}
		});

		textField_sib3_wpno.addValidator(new RegexpValidator("^[0-9]{10}$", "Invalid Sibiling 3 work Phone No"));
		textField_sib3_wpno.addBlurListener(new BlurListener() {

			@Override
			public void blur(BlurEvent event) {
				// TODO Auto-generated method stub
				if (textField_sib3_wpno.isValid() == false) {
					textField_sib3_wpno.setValidationVisible(true);
				} else if (textField_sib3_wpno.isValid() == true) {
					textField_sib3_wpno.setValidationVisible(false);
				}

			}
		});

		textField4_sib3_wpno.addValidator(new RegexpValidator("^[0-9]{10}$", "Invalid Sibiling 4 work Phone No"));
		textField4_sib3_wpno.addBlurListener(new BlurListener() {

			@Override
			public void blur(BlurEvent event) {
				// TODO Auto-generated method stub
				if (textField4_sib3_wpno.isValid() == false) {
					textField4_sib3_wpno.setValidationVisible(true);
				} else if (textField4_sib3_wpno.isValid() == true) {
					textField4_sib3_wpno.setValidationVisible(false);
				}

			}
		});

		textField_emg1_hpno.addValidator(new RegexpValidator("^[0-9]{10}$", "Invalid Emegency Person 1 Home Phone No"));
		textField_emg1_hpno.addBlurListener(new BlurListener() {

			@Override
			public void blur(BlurEvent event) {
				// TODO Auto-generated method stub
				if (textField_emg1_hpno.isValid() == false) {
					textField_emg1_hpno.setValidationVisible(true);
				} else if (textField_emg1_hpno.isValid() == true) {
					textField_emg1_hpno.setValidationVisible(false);
				}

			}
		});

		textField_emg1_alterpNo
				.addValidator(new RegexpValidator("^[0-9]{10}$", "Invalid Emegency Person 1 Alter Phone No"));
		textField_emg1_alterpNo.addBlurListener(new BlurListener() {

			@Override
			public void blur(BlurEvent event) {
				// TODO Auto-generated method stub
				if (textField_emg1_alterpNo.isValid() == false) {
					textField_emg1_alterpNo.setValidationVisible(true);
				} else if (textField_emg1_alterpNo.isValid() == true) {
					textField_emg1_alterpNo.setValidationVisible(false);
				}

			}
		});

		textField_emg2_hPno.addValidator(new RegexpValidator("^[0-9]{10}$", "Invalid Emegency Person 2 Home Phone No"));
		textField_emg2_hPno.addBlurListener(new BlurListener() {

			@Override
			public void blur(BlurEvent event) {
				// TODO Auto-generated method stub
				if (textField_emg2_hPno.isValid() == false) {
					textField_emg2_hPno.setValidationVisible(true);
				} else if (textField_emg2_hPno.isValid() == true) {
					textField_emg2_hPno.setValidationVisible(false);
				}

			}
		});

		// tab1_per_det.setStyleName(Reindeer.TABLE_STRONG);
		
		btn_submit.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub

				if (textField_homePhone.isValid() == false) {
					Notification.show("Invalied Home Phone No");
					textField_homePhone.focus();
				}

				else if (textField_alterPhone.isValid() == false) {
					Notification.show("Invalied Alter Phone No");
					textField_alterPhone.focus();
				}

				else if (textField_spousePhone1.isValid() == false) {
					Notification.show("Invalied Spouse Mobile Phone No");
					textField_spousePhone1.focus();
				}

				else if (textField_email.isValid() == false) {
					Notification.show("Invalied Email");
					textField_email.focus();
				}

				else if (textField_spousePhone.isValid() == false) {
					Notification.show("Invalied Spouse Official Phone No");
					textField_spousePhone.focus();
				}

				else if (textField_w_f_Pno.isValid() == false) {
					Notification.show("Invalied Father's Work Phone No");
					textField_w_f_Pno.focus();
				} else if (textField__m_pno.isValid() == false) {
					Notification.show("Invalied Mother's Work Phone No");
					textField__m_pno.focus();
				}

				else if (textField_sib3_wpno.isValid() == false) {
					Notification.show("Invalied Sibiling 3 Work Phone No");
					textField_sib3_wpno.focus();
				}

				else if (textField4_sib3_wpno.isValid() == false) {
					Notification.show("Invalied Sibiling 4 Work Phone No");
					textField4_sib3_wpno.focus();
				}

				else if (textField_emg1_hpno.isValid() == false) {
					Notification.show("Invalid Emegency Person 1 Home Phone No");
					textField_emg1_hpno.focus();
				}

				else if (textField_emg1_alterpNo.isValid() == false) {
					Notification.show("Invalid Emegency Person 1 Alter Phone No");
					textField_emg1_alterpNo.focus();
				} else if (textField_emg2_hPno.isValid() == false) {
					Notification.show("Invalid Emegency Person 2 Home Phone No");
					textField_emg2_hPno.focus();
				}

				else if (textField_epf.getValue().isEmpty()) {
					Notification.show("There is No EPF");
				}

				else if (textArea_padress.getValue().trim().toString().isEmpty() || textField_pcity.getValue().trim().isEmpty()
						|| textField_pstate.getValue().trim().isEmpty()) {
					Notification.show("Enter Permenant Address Missing details");
				}

				else if (textArea_taddress.getValue().trim().toString().isEmpty() || textField_tcity.getValue().trim().isEmpty()
						|| textField_tstate.getValue().trim().isEmpty()) {
					Notification.show("Enter Tempoarary Address Missing details");
				}

				else if (textField_homePhone.getValue().trim().isEmpty()) {
					Notification.show("Enter Home Phone No");
				}

				else if (textField_email.getValue().trim().isEmpty()) {
					Notification.show("Enter Email");
				}

				else if (comboBox_mart_status.getValue().toString() == null) {
					Notification.show("Select Martial Status");
				}

				else if (textField_emg1_hpno.getValue().toString() == null) {
					Notification.show("Invalid Emegency Person 1 Home Phone No");
				}

				else {

					Window sal = new Window("Confirm");

					HR_Emp_Details_OK_CancelSub HR_Emp_Details_OK_CancelSub = new HR_Emp_Details_OK_CancelSub();
					String suser = "";
					suser = "<caption align='bottom'><b><font size='2'><font color='black'>" + "<br>" + "USER"
							+ "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp: " + username + "<br>" + "BRANCH  : " + branch_name
							+ "<br>" + "EPF" + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp : " + epf_no + "<br>"
							+ "Please Confirm Details " + "</caption></b></font>";
					HR_Emp_Details_OK_CancelSub.label_CONFIRM.setValue(suser);
					HR_Emp_Details_OK_CancelSub.button_OK.addClickListener(new ClickListener() {

						@Override
						public void buttonClick(ClickEvent event) {
							// TODO Auto-generated method stub
							Connection co = null;
							Statement st = null;
							ResultSet rs = null;

							try {

								co = JDBC_MY.con();
								st = co.createStatement();

								String epf = textField_epf.getValue().toString();
								String pAddres = textArea_padress.getValue().trim().toString().toUpperCase();
								String pcity = textField_pcity.getValue().trim().toUpperCase();
								String pstate = textField_pstate.getValue().trim().toUpperCase();
								String pzip = textField_pzip.getValue().trim().toUpperCase();
								String tAddress = textArea_taddress.getValue().trim().toString().toUpperCase();
								String tcity = textField_tcity.getValue().trim().toUpperCase();
								String tstate = textField_tstate.getValue().trim().toUpperCase();
								String tzip = textField_tzip.getValue().trim().toUpperCase();
								String hmePhone = textField_homePhone.getValue().trim();
								String alterPhone = textField_alterPhone.getValue().trim();
								String email = textField_email.getValue().trim();
								String maritalStatus = comboBox_mart_status.getValue().toString();
								String spouseName = textField_spouseName.getValue().trim().toUpperCase();
								String spouseEmp = textField_spousEmp.getValue().trim().toUpperCase();
								String spouseCno = textField_spousePhone.getValue().trim();
								String spouseMobile = textField_spousePhone1.getValue().trim();
								String fthrName = textField_fName.getValue().trim().toUpperCase();
								String fthrOccup = textField_fOccup.getValue().trim().toUpperCase();
								String fthrPno = textField_w_f_Pno.getValue().trim();
								String fthrWorkLocation = textField_f_workloc.getValue().trim().toUpperCase();
								String mthrName = textField_mName.getValue().trim().toUpperCase();
								String mthrPno = textField__m_pno.getValue().trim();
								String mthrWorkLocation = textField_m_wLoc.getValue().trim().toUpperCase();
								String motherOccupation = textField_m_occup.getValue().trim().toUpperCase();
								String sib1Name = textField_sib21.getValue().trim().toUpperCase();
								String sib1Occup = textField_occ_sib1.getValue().trim().toUpperCase();
								String sib1Pno = textField_wpno_s1.getValue().trim().toUpperCase();
								String sib2Name = textField_sib2.getValue().trim().toUpperCase();
								String sib2Occup = textField_sib2_occup.getValue().trim().toUpperCase();
								String sib2Pno = textField_sib2_wpno.getValue().trim().toUpperCase();
								String sib3Name = textField_sib3.getValue().trim();
								String sib3Occup = textField_occ_s3.getValue().trim().toUpperCase();
								String sib3Pno = textField_sib3_wpno.getValue().trim();
								String sib4Name = textField_sib4.getValue().trim();
								String sib4Occup = textField_occ_sib4.getValue().trim().toUpperCase();
								String sib4Pno = textField4_sib3_wpno.getValue().trim().toUpperCase();

								String emg1Fullnme = textField_emg1Fullnme.getValue().trim().toUpperCase();
								String emg1PermAddress = textArea_emg1PAddress.getValue().trim().toString().toUpperCase();
								String emg1City = textField_emg1_city.getValue().trim().toUpperCase();
								String emg1State = textField_emg1_state.getValue().trim().toUpperCase();
								String emg1Zip = textField_emg1_zip.getValue().trim();
								String emg1homePno = textField_emg1_hpno.getValue().trim();
								String emg1AlterPno = textField_emg1_alterpNo.getValue().trim();
								String emg1Relation = textField_emg1_reltion.getValue().trim().toUpperCase();
								String emg2Fullnme = textField_emg2_fullName.getValue().trim().toUpperCase();
								String emg2permAddress = textArea_emg2_paddress.getValue().trim().toString().toUpperCase();
								String emg2pcity = textField_emg2_city1.getValue().trim().toUpperCase();
								String emg2state = textField_emg2_state.getValue().trim().toUpperCase();
								String emg2zip = textField_emg2_zip.getValue().trim();
								String emg2homePno = textField_emg2_hPno.getValue().trim();
								String emg2Relation = textField_emg2_relation.getValue().trim().toUpperCase();
								System.out.println(emg1PermAddress);

								String currdate = "";
								SimpleDateFormat frmtter = new SimpleDateFormat("yyyy-MM-dd h:mm:ss a");
								currdate = frmtter.format(new java.util.Date(System.currentTimeMillis()));

						String sql = "INSERT INTO hr_personal_details(epf,permanent_address,p_city,p_state,p_zip_code,temporary_address,t_city,t_state,t_zip_code,home_phone,"
								+ "alter_phone,email,mari_status,spouse_name,spouse_emp,spouse_mobile,spouse_phone,father_name,father_occup,father_pno,father_work_location,"
								+ "mother_name,mother_occup,mother_pno,mother_work_location,sibiling1_name,sibiling1_occupation,sibilling1_pno,sibiling2_name,sibiling2_occupation,"
								+ "sibilling2_pno,sibiling3_name,sibiling3_occupation,sibiling3_pno,sibiling4_name,sibiling4_occupation,sibiling4_pno,emg1_fullname,emg1_PermAddress,"
								+ "emg1_City,emg1_State,emg1_Zip,emg1_homePno,emg1_AlterPno,emg1_Relation,emg2_Fullnme,emg2_permAddress,emg2_pcity,emg2_state,emg2_zip,emg2_homePno,"
								+ "emg2_Relation,datetime) values("
								+ "'80"
										+ epf + "','" + pAddres + "','" + pcity + "','" + pstate + "','" + pzip + "','"
										+ tAddress + "','" + tcity + "','" + tstate + "','" + tzip + "','" + hmePhone
										+ "','" + alterPhone + "','" + email + "','" + maritalStatus + "','"
										+ spouseName + "','" + spouseEmp + "','" + spouseMobile + "','" + spouseCno
										+ "','" + fthrName + "','" + fthrOccup + "','" + fthrPno + "','"
										+ fthrWorkLocation + "','" + mthrName + "','" + motherOccupation + "','"
										+ mthrPno + "','" + mthrWorkLocation + "','" + sib1Name + "','" + sib1Occup
										+ "','" + sib1Pno + "','" + sib2Name + "','" + sib2Occup + "','" + sib2Pno
										+ "','" + sib3Name + "','" + sib3Occup + "','" + sib3Pno + "','" + sib4Name
										+ "','" + sib4Occup + "','" + sib4Pno + "','" + emg1Fullnme + "','"
										+ emg1PermAddress + "','" + emg1City + "','" + emg1State + "','" + emg1Zip
										+ "','" + emg1homePno + "','" + emg1AlterPno + "','" + emg1Relation + "','"
										+ emg2Fullnme + "','" + emg2permAddress + "','" + emg2pcity + "','" + emg2state
										+ "','" + emg2zip + "','" + emg2homePno + "','" + emg2Relation + "','"
										+ username + " " + currdate + "')";
								System.out.println(sql);
								try {
									rowaffected = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
									ResultSet rss = st.getGeneratedKeys();
									if (rss.next()) {
										risultato = rss.getInt(1);
										System.out.println(risultato + "getlastid");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								if (rowaffected > 0) {
									Notification.show("Data Entered Succesfully");
									sal.close();
									// loadtable();
									textField_epf.setValue("");
									textArea_padress.setValue("");
									textField_pcity.setValue("");
									textField_pstate.setValue("");
									textField_pzip.setValue("");
									textArea_taddress.setValue("");
									textField_tcity.setValue("");
									textField_tstate.setValue("");
									textField_tzip.setValue("");
									textField_homePhone.setValue("");
									textField_alterPhone.setValue("");
									textField_email.setValue("");
									comboBox_mart_status.setValue(null);
									textField_spouseName.setValue("");
									textField_spousEmp.setValue("");
									textField_spousePhone1.setValue("");
									textField_spousePhone.setValue("");
									textField_fName.setValue("");
									textField_fOccup.setValue("");
									textField_w_f_Pno.setValue("");
									textField_f_workloc.setValue("");
									textField_mName.setValue("");
									textField_m_occup.setValue("");
									textField__m_pno.setValue("");
									textField_sib21.setValue("");
									textField_occ_sib1.setValue("");
									textField_wpno_s1.setValue("");
									textField_sib2.setValue("");
									textField_sib2_occup.setValue("");
									textField_sib2_wpno.setValue("");
									textField_m_wLoc.setValue("");
									textField_sib3.setValue("");
									textField_sib4.setValue("");
									textField_occ_s3.setValue("");
									textField_sib3_wpno.setValue("");
									textField_occ_sib4.setValue("");
									textField4_sib3_wpno.setValue("");
									textField_emg1Fullnme.setValue("");
									textArea_emg1PAddress.setValue("");
									textField_emg1_city.setValue("");
									textField_emg1_state.setValue("");
									textField_emg1_zip.setValue("");
									textField_emg1_hpno.setValue("");
									textField_emg1_alterpNo.setValue("");
									textField_emg1_reltion.setValue("");
									textField_emg2_fullName.setValue("");
									textField_emg2_city1.setValue("");
									textField_emg2_state.setValue("");
									textField_emg2_zip.setValue("");
									textField_emg2_hPno.setValue("");
									textField_emg2_relation.setValue("");
									textArea_emg2_paddress.setValue("");

								} else {
									Notification.show("Value Not Added");
									sal.close();
								}

							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								try {
									if (st != null) {
										st.close();
									}
									if (co != null) {
										co.close();
									}

								} catch (Exception e2) {
									// TODO: handle exception
									e2.printStackTrace();
								}
							}

						}
					});

					HR_Emp_Details_OK_CancelSub.button_CANCEL.addClickListener(new ClickListener() {

						@Override
						public void buttonClick(ClickEvent event) {
							// TODO Auto-generated method stub
							Notification.show("Not Completed");
							sal.close();
						}
					});
					sal.setContent(HR_Emp_Details_OK_CancelSub);

					sal.setWidth("300px");
					sal.setHeight("200px");
					sal.center();
					sal.setModal(true);
					sal.setResizable(false);
					UI.getCurrent().addWindow(sal);
				}

			}
		});
		
		
		
		button_srch.setClickShortcut(ShortcutAction.KeyCode.ENTER);
		button_srch.addStyleName(Reindeer.BUTTON_DEFAULT);
		button_srch.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub

				if (textField_epf.getValue().toString().trim().equals("")) {
					Notification.show("Enter an EPF NO");
				} else {

					Connection co1 = null;
					Statement st1 = null;
					ResultSet rs = null;
					try {

						// textField_epf.setValue("");

						textArea_padress.setValue("");
						textField_pcity.setValue("");
						textField_pstate.setValue("");
						textField_pzip.setValue("");
						textArea_taddress.setValue("");
						textField_tcity.setValue("");
						textField_tstate.setValue("");
						textField_tzip.setValue("");
						textField_homePhone.setValue("");
						textField_alterPhone.setValue("");
						textField_email.setValue("");
						comboBox_mart_status.setValue(null);
						textField_spouseName.setValue("");
						textField_spousEmp.setValue("");
						textField_spousePhone1.setValue("");
						textField_spousePhone.setValue("");
						textField_fName.setValue("");
						textField_fOccup.setValue("");
						textField_w_f_Pno.setValue("");
						textField_f_workloc.setValue("");
						textField_mName.setValue("");
						textField_m_occup.setValue("");
						textField__m_pno.setValue("");
						textField_sib21.setValue("");
						textField_m_wLoc.setValue("");
						textField_sib3.setValue("");
						textField_sib4.setValue("");
						textField_occ_s3.setValue("");
						textField_sib3_wpno.setValue("");
						textField_occ_sib4.setValue("");
						textField4_sib3_wpno.setValue("");
						textField_emg1Fullnme.setValue("");
						textArea_emg1PAddress.setValue("");
						textField_emg1_city.setValue("");
						textField_emg1_state.setValue("");
						textField_emg1_zip.setValue("");
						textField_emg1_hpno.setValue("");
						textField_emg1_alterpNo.setValue("");
						textField_emg1_reltion.setValue("");
						textField_emg2_fullName.setValue("");
						textField_emg2_city1.setValue("");
						textField_emg2_state.setValue("");
						textField_emg2_zip.setValue("");
						textField_emg2_hPno.setValue("");
						textField_emg2_relation.setValue("");
						textArea_emg2_paddress.setValue("");

						co1 = JDBC_MY.con();
						st1 = co1.createStatement();

						int frepf = Integer.parseInt(textField_epf.getValue().trim());
						String serch = new DecimalFormat("0000").format(frepf);
						// String serch=textField_epf.getValue().trim();
						System.out.println("sqqlllllllllllll");
						rs = st1.executeQuery(
								"SELECT E.emp_id,H.permanent_address,H.p_city,H.p_state,H.p_zip_code,H.temporary_address,H.t_city,H.t_state,H.t_zip_code,"
										+ "H.home_phone,H.alter_phone,H.email,H.mari_status,H.spouse_name,H.spouse_emp,H.spouse_mobile,H.spouse_phone,H.father_name,H.father_occup,H.father_pno,H.father_work_location,H.mother_name,H.mother_occup,H.mother_pno,"
										+ "H.mother_work_location,H.sibiling1_name,H.sibiling1_occupation,H.sibilling1_pno,H.sibiling2_name,H.sibiling2_occupation,H.sibilling2_pno,H.sibiling3_name,"
										+ "H.sibiling3_occupation,H.sibiling3_pno,H.sibiling4_name,H.sibiling4_occupation,H.sibiling4_pno,H.emg1_fullname,"
										+ "H.emg1_PermAddress,H.emg1_City,H.emg1_State,H.emg1_Zip,H.emg1_homePno,H.emg1_AlterPno,H.emg1_Relation,H.emg2_Fullnme,"
										+ "H.emg2_permAddress,H.emg2_pcity,H.emg2_state,H.emg2_zip,H.emg2_homePno,H.emg2_Relation,H.datetime FROM e_details.e_details E LEFT OUTER JOIN e_details.hr_personal_details H ON E.emp_id=H.epf where  E.emp_id='80"
										+ serch + "'");
						System.out.println(serch);
						if (rs.next()) {
							System.out.println(rs.getString("emp_id"));
							button_srch.setVisible(true);
							String empid = rs.getString("emp_id");
							String name = rs.getString("permanent_address");
							String pCity = rs.getString("p_city");
							String p_state = rs.getString("p_state");
							String p_zip_code = rs.getString("p_zip_code");
							String temporary_address = rs.getString("temporary_address");
							String t_city = rs.getString("t_city");
							String t_state = rs.getString("t_state");
							String t_zip_code = rs.getString("t_zip_code");
							String home_phone = rs.getString("home_phone");
							String alter_phone = rs.getString("alter_phone");
							String email = rs.getString("email");
							String mari_status = rs.getString("mari_status");
							String spouse_name = rs.getString("spouse_name");
							String spouse_emp = rs.getString("spouse_emp");
							String spouseMpno = rs.getString("spouse_mobile");
							String spouse_phone = rs.getString("spouse_phone");
							String father_name = rs.getString("father_name");
							String father_occup = rs.getString("father_occup");
							String father_pno = rs.getString("father_pno");
							String father_work_location = rs.getString("father_work_location");
							String mother_name = rs.getString("mother_name");
							String mother_occup = rs.getString("mother_occup");
							String mother_pno = rs.getString("mother_pno");
							String mother_work_location = rs.getString("mother_work_location");
							String sibiling1_name = rs.getString("sibiling1_name");
							String sibiling1_occupation = rs.getString("sibiling1_occupation");
							String sibilling1_pno = rs.getString("sibilling1_pno");
							String sibiling2_name = rs.getString("sibiling2_name");
							String sibiling2_occupation = rs.getString("sibiling2_occupation");
							String sibilling2_pno = rs.getString("sibilling2_pno");
							String sibiling3_name = rs.getString("sibiling3_name");
							String sibiling3_occupation = rs.getString("sibiling3_occupation");
							String sibiling3_pno = rs.getString("sibiling3_pno");
							String sibiling4_name = rs.getString("sibiling4_name");
							String sibiling4_occupation = rs.getString("sibiling4_occupation");
							String sibiling4_pno = rs.getString("sibiling4_pno");
							String emg1_fullname = rs.getString("emg1_fullname");
							String emg1_PermAddress = rs.getString("emg1_PermAddress");
							String emg1_City = rs.getString("emg1_City");
							String emg1_State = rs.getString("emg1_State");
							String emg1_Zip = rs.getString("emg1_Zip");
							String emg1_homePno = rs.getString("emg1_homePno");
							String emg1_AlterPno = rs.getString("emg1_AlterPno");
							String emg1_Relation = rs.getString("emg1_Relation");
							String emg2_Fullnme = rs.getString("emg2_Fullnme");
							String emg2_permAddress = rs.getString("emg2_permAddress");
							String emg2_pcity = rs.getString("emg2_pcity");
							String emg2_state = rs.getString("emg2_state");
							String emg2_zip = rs.getString("emg2_zip");
							String emg2_homePno = rs.getString("emg2_homePno");
							String emg2_Relation = rs.getString("emg2_Relation");
							String datetime = rs.getString("datetime");	
						
							
							/*try {
							if(!name.isEmpty()) {
								btn_submit.setVisible(true);
							}
							}catch(Exception e) {
								
							}*/
							
							if (name == null) {
								textArea_padress.setValue("");
								btn_submit.setVisible(true);
							} else {
								textArea_padress.setValue(name);
								btn_submit.setVisible(false);				
								}

							if (pCity == null) {
								textField_pcity.setValue("");
							} else {
								textField_pcity.setValue(pCity);
							}

							if (p_state == null) {
								textField_pstate.setValue("");
							} else {
								textField_pstate.setValue(p_state);
							}
							// textField_epf.setEnabled(false);

							if (p_zip_code == null) {
								textField_pzip.setValue("");
							} else {
								textField_pzip.setValue(p_zip_code);
							}

							if (temporary_address == null) {
								textArea_taddress.setValue("");
							} else {
								textArea_taddress.setValue(temporary_address);
							}

							if (t_city == null) {
								textField_tcity.setValue("");
							} else {
								textField_tcity.setValue(t_city);
								;
							}

							if (t_state == null) {
								textField_tstate.setValue("");
							} else {
								textField_tstate.setValue(t_state);
							}

							if (t_zip_code == null) {
								textField_tzip.setValue("");
							} else {
								textField_tzip.setValue(t_zip_code);
							}

							if (home_phone == null) {
								textField_homePhone.setValue("");
							} else {
								textField_homePhone.setValue(home_phone);
							}

							if (alter_phone == null) {
								textField_alterPhone.setValue("");
							} else {
								textField_alterPhone.setValue(alter_phone);
							}

							if (email == null) {
								textField_email.setValue("");
							} else {
								textField_email.setValue(email);
							}

							if (mari_status == null) {
								comboBox_mart_status.setValue("");
							} else {
								comboBox_mart_status.setValue(mari_status);
							}

							if (spouse_name == null) {
								textField_spouseName.setValue("");
							} else {
								textField_spouseName.setValue(spouse_name);
							}

							if (spouse_emp == null) {
								textField_spousEmp.setValue("");
							} else {
								textField_spousEmp.setValue(spouse_emp);
							}
							
						
							
							if (spouseMpno == null) {
								textField_spousePhone1.setValue("");
							} else {
								textField_spousePhone1.setValue(spouseMpno);
							}
							if (spouse_phone == null) {
								textField_spousePhone.setValue("");
							} else {
								textField_spousePhone.setValue(spouse_phone);
							}

							
							if (father_name == null) {
								textField_fName.setValue("");
							} else {
								textField_fName.setValue(father_name);
							}

							if (father_occup == null) {
								textField_fOccup.setValue("");
							} else {
								textField_fOccup.setValue(father_occup);
							}

							if (father_pno == null) {
								textField_w_f_Pno.setValue("");
							} else {
								textField_w_f_Pno.setValue(father_pno);
							}

							if (father_work_location == null) {
								textField_f_workloc.setValue("");
							} else {
								textField_f_workloc.setValue(father_work_location);
							}

							if (mother_name == null) {
								textField_mName.setValue("");
							} else {
								textField_mName.setValue(mother_name);
							}

							if (mother_occup == null) {
								textField_m_occup.setValue("");
							} else {
								textField_m_occup.setValue(mother_occup);
							}

							if (mother_pno == null) {
								textField__m_pno.setValue("");
							} else {
								textField__m_pno.setValue(mother_pno);
							}

							if (mother_work_location == null) {
								textField_m_wLoc.setValue("");
							} else {
								textField_m_wLoc.setValue(mother_work_location);
							}

							if (sibiling1_name == null) {
								textField_sib21.setValue("");
							} else {
								textField_sib21.setValue(sibiling1_name);
							}

							if (sibiling1_occupation == null) {
								textField_occ_sib1.setValue("");
							} else {
								textField_occ_sib1.setValue(sibiling1_occupation);
							}

							if (sibilling1_pno == null) {
								textField_wpno_s1.setValue("");
							} else {
								textField_wpno_s1.setValue(sibilling1_pno);
							}

							if (sibiling2_name == null) {
								textField_sib2.setValue("");
							} else {
								textField_sib2.setValue(sibiling2_name);
							}

							if (sibiling2_occupation == null) {
								textField_sib2_occup.setValue("");
							} else {
								textField_sib2_occup.setValue(sibiling2_occupation);
							}

							if (sibilling2_pno == null) {
								textField_sib2_wpno.setValue("");
							} else {
								textField_sib2_wpno.setValue(sibilling2_pno);
							}

							if (sibiling3_name == null) {
								textField_sib3.setValue("");
							} else {
								textField_sib3.setValue(sibiling3_name);
							}

							if (sibiling3_occupation == null) {
								textField_occ_s3.setValue("");
							} else {
								textField_occ_s3.setValue(sibiling3_occupation);
							}

							if (sibiling3_pno == null) {
								textField_sib3_wpno.setValue("");
							} else {
								textField_sib3_wpno.setValue(sibiling3_pno);
							}

							if (sibiling4_name == null) {
								textField_sib4.setValue("");
							} else {
								textField_sib4.setValue(sibiling4_name);
							}

							if (sibiling4_occupation == null) {
								textField_occ_sib4.setValue("");
							} else {
								textField_occ_sib4.setValue(sibiling4_occupation);
							}

							if (sibiling4_pno == null) {
								textField4_sib3_wpno.setValue("");
							} else {
								textField4_sib3_wpno.setValue(sibiling4_pno);
							}

							if (emg1_fullname == null) {
								textField_emg1Fullnme.setValue("");
							} else {
								textField_emg1Fullnme.setValue(emg1_fullname);
							}

							if (emg1_PermAddress == null) {
								textArea_emg1PAddress.setValue("");
							} else {
								textArea_emg1PAddress.setValue(emg1_PermAddress);
							}

							if (emg1_City == null) {
								textField_emg1_city.setValue("");
							} else {
								textField_emg1_city.setValue(emg1_City);
							}

							if (emg1_State == null) {
								textField_emg1_state.setValue("");
							} else {
								textField_emg1_state.setValue(emg1_State);
							}

							if (emg1_Zip == null) {
								textField_emg1_zip.setValue("");
							} else {
								textField_emg1_zip.setValue(emg1_Zip);
							}

							if (emg1_homePno == null) {
								textField_emg1_hpno.setValue("");
							} else {
								textField_emg1_hpno.setValue(emg1_homePno);
							}

							if (emg1_AlterPno == null) {
								textField_emg1_alterpNo.setValue("");
							} else {
								textField_emg1_alterpNo.setValue(emg1_AlterPno);
							}

							if (emg1_Relation == null) {
								textField_emg1_reltion.setValue("");
							} else {
								textField_emg1_reltion.setValue(emg1_Relation);
							}

							if (emg2_Fullnme == null) {
								textField_emg2_fullName.setValue("");
							} else {
								textField_emg2_fullName.setValue(emg2_Fullnme);
							}

							if (emg2_permAddress == null) {
								textArea_emg2_paddress.setValue("");
							} else {
								textArea_emg2_paddress.setValue(emg2_permAddress);
							}

							if (emg2_pcity == null) {
								textField_emg2_city1.setValue("");
							} else {
								textField_emg2_city1.setValue(emg2_pcity);
							}

							if (emg2_state == null) {
								textField_emg2_state.setValue("");
							} else {
								textField_emg2_state.setValue(emg2_state);
							}

							if (emg2_zip == null) {
								textField_emg2_zip.setValue("");
							} else {
								textField_emg2_zip.setValue(emg2_zip);
							}

							if (emg2_homePno == null) {
								textField_emg2_hPno.setValue("");
							} else {
								textField_emg2_hPno.setValue(emg2_homePno);
							}

							if (emg2_Relation == null) {
								textField_emg2_relation.setValue("");
							} else {
								textField_emg2_relation.setValue(emg2_Relation);
							}

						}

						else {
							Notification.show("Invalied EPF");
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {

						try {
							if (st1 != null) {
								st1.close();
							}

							if (co1 != null) {
								co1.close();
							}

						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}

					}

				}

			}
		});

		btn_update.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub

				if (textField_homePhone.isValid() == false) {
					Notification.show("Invalied Home Phone No");
					textField_homePhone.focus();
				}

				else if (textField_alterPhone.isValid() == false) {
					Notification.show("Invalied Alter Phone No");
					textField_alterPhone.focus();
				}

				else if (textField_spousePhone1.isValid() == false) {
					Notification.show("Invalied Spouse Phone No");
					textField_spousePhone1.focus();
				}

				else if (textField_email.isValid() == false) {
					Notification.show("Invalied Email");
					textField_email.focus();
				}

				else if (textField_spousePhone.isValid() == false) {
					Notification.show("Invalied Phone No");
					textField_spousePhone.focus();
				}

				else if (textField_w_f_Pno.isValid() == false) {
					Notification.show("Invalied Father's Work Phone No");
					textField_w_f_Pno.focus();
				} else if (textField__m_pno.isValid() == false) {
					Notification.show("Invalied Mother's Work Phone No");
					textField__m_pno.focus();
				}

				else if (textField_sib3_wpno.isValid() == false) {
					Notification.show("Invalied Sibiling 3 Work Phone No");
					textField_sib3_wpno.focus();
				}

				else if (textField4_sib3_wpno.isValid() == false) {
					Notification.show("Invalied Sibiling  Work Phone No");
					textField4_sib3_wpno.focus();
				}

				else if (textField_emg1_hpno.isValid() == false) {
					Notification.show("Invalid Emegency Person 1 Home Phone No");
					textField_emg1_hpno.focus();
				}

				else if (textField_emg1_alterpNo.isValid() == false) {
					Notification.show("Invalid Emegency Person 1 Alter Phone No");
					textField_emg1_alterpNo.focus();
				} else if (textField_emg2_hPno.isValid() == false) {
					Notification.show("Invalid Emegency Person 2 Home Phone No");
					textField_emg2_hPno.focus();
				}

				else if (textField_epf.getValue().isEmpty()) {
					Notification.show("There is No EPF");
				}

				else if (textArea_padress.getValue().trim().isEmpty() || textField_pcity.getValue().trim().isEmpty()
						|| textField_pstate.getValue().trim().isEmpty()) {
					Notification.show("Enter Permenant Address Missing details");
				}

				else if (textArea_taddress.getValue().trim().isEmpty() || textField_tcity.getValue().trim().isEmpty()
						|| textField_tstate.getValue().trim().isEmpty()) {
					Notification.show("Enter Tempoarry Address Missing details");
				}

				else if (textField_homePhone.getValue().trim().isEmpty()) {
					Notification.show("Enter Home Phone No");
				}

				else if (textField_email.getValue().trim().isEmpty()) {
					Notification.show("Enter Home Email");
				}

				else if (comboBox_mart_status.getValue().toString() == null) {
					Notification.show("Enter the Email Address");
				}

				else if (textField_emg1_hpno.getValue().toString() == null) {
					Notification.show("Invalid Emegency Person 1 Home Phone No");
				}

				else {

					Window sal = new Window("Confirm Update");

					HR_Emp_Details_OK_CancelSub HR_Emp_Details_OK_CancelSub = new HR_Emp_Details_OK_CancelSub();
					String suser = "";
					suser = "<caption align='bottom'><b><font size='2'><font color='black'>" + "<br>" + "USER"
							+ "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp: " + username + "<br>" + "BRANCH  : " + branch_name
							+ "<br>" + "EPF" + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp: " + epf_no + "<br>"
							+ "Please Confirm Details " + "</caption></b></font>";
					HR_Emp_Details_OK_CancelSub.label_CONFIRM.setValue(suser);
					HR_Emp_Details_OK_CancelSub.button_OK.addClickListener(new ClickListener() {

						@Override
						public void buttonClick(ClickEvent event) {
							// TODO Auto-generated method stub
							Connection co = null;
							Statement st = null;
							ResultSet rs = null;

							try {

								co = JDBC_MY.con();
								st = co.createStatement();

								String epf = textField_epf.getValue().toString();
								String pAddres = textArea_padress.getValue().trim().toString().toUpperCase();
								String pcity = textField_pcity.getValue().trim().toUpperCase();
								String pstate = textField_pstate.getValue().trim().toUpperCase();
								String pzip = textField_pzip.getValue().trim().toUpperCase();
								String tAddress = textArea_taddress.getValue().trim().toString().toUpperCase();
								String tcity = textField_tcity.getValue().trim().toUpperCase();
								String tstate = textField_tstate.getValue().trim().toUpperCase();
								String tzip = textField_tzip.getValue().trim().toUpperCase();
								String hmePhone = textField_homePhone.getValue().trim();
								String alterPhone = textField_alterPhone.getValue().trim();
								String email = textField_email.getValue().trim();
								String maritalStatus = comboBox_mart_status.getValue().toString();
								String spouseName = textField_spouseName.getValue().trim().toUpperCase();
								String spouseEmp = textField_spousEmp.getValue().trim().toUpperCase();
								String spouseCno = textField_spousePhone.getValue().trim();
								String spouseMobile = textField_spousePhone1.getValue().trim();
								String fthrName = textField_fName.getValue().trim().toUpperCase();
								String fthrOccup = textField_fOccup.getValue().trim().toUpperCase();
								String fthrPno = textField_w_f_Pno.getValue().trim();
								String fthrWorkLocation = textField_f_workloc.getValue().trim().toUpperCase();
								String mthrName = textField_mName.getValue().trim().toUpperCase();
								String mthrPno = textField__m_pno.getValue().trim();
								String mthrWorkLocation = textField_m_wLoc.getValue().trim().toUpperCase();
								String motherOccupation = textField_m_occup.getValue().trim().toUpperCase();
								String sib1Name = textField_sib21.getValue().trim().toUpperCase();
								String sib1Occup = textField_occ_sib1.getValue().trim().toUpperCase();
								String sib1Pno = textField_wpno_s1.getValue().trim().toUpperCase();
								String sib2Name = textField_sib2.getValue().trim().toUpperCase();
								String sib2Occup = textField_sib2_occup.getValue().trim().toUpperCase();
								String sib2Pno = textField_sib2_wpno.getValue().trim().toUpperCase();
								String sib3Name = textField_sib3.getValue().trim();
								String sib3Occup = textField_occ_s3.getValue().trim().toUpperCase();
								String sib3Pno = textField_sib3_wpno.getValue().trim();
								String sib4Name = textField_sib4.getValue().trim();
								String sib4Occup = textField_occ_sib4.getValue().trim().toUpperCase();
								String sib4Pno = textField4_sib3_wpno.getValue().trim().toUpperCase();

								String emg1Fullnme = textField_emg1Fullnme.getValue().trim().toUpperCase();
								String emg1PermAddress = textArea_emg1PAddress.getValue().trim().toString().toUpperCase();
								String emg1City = textField_emg1_city.getValue().trim().toUpperCase();
								String emg1State = textField_emg1_state.getValue().trim().toUpperCase();
								String emg1Zip = textField_emg1_zip.getValue().trim();
								String emg1homePno = textField_emg1_hpno.getValue().trim();
								String emg1AlterPno = textField_emg1_alterpNo.getValue().trim();
								String emg1Relation = textField_emg1_reltion.getValue().trim().toUpperCase();
								String emg2Fullnme = textField_emg2_fullName.getValue().trim().toUpperCase();
								String emg2permAddress = textArea_emg2_paddress.getValue().trim().toString().toUpperCase();
								String emg2pcity = textField_emg2_city1.getValue().trim().toUpperCase();
								String emg2state = textField_emg2_state.getValue().trim().toUpperCase();
								String emg2zip = textField_emg2_zip.getValue().trim();
								String emg2homePno = textField_emg2_hPno.getValue().trim();
								String emg2Relation = textField_emg2_relation.getValue().trim().toUpperCase();
								System.out.println(emg1PermAddress);

								String currdate = "";
								SimpleDateFormat frmtter = new SimpleDateFormat("yyyy-MM-dd h:mm:ss a");
								currdate = frmtter.format(new java.util.Date(System.currentTimeMillis()));

								String sql = "UPDATE hr_personal_details SET permanent_address='"
										+ pAddres + "',p_city='" + pcity + "',p_state='" + pstate + "',p_zip_code='"
										+ pzip + "',temporary_address='" + tAddress + "',t_city='" + tcity+ "',t_state='" + tstate + "',t_zip_code='" + tzip + "',home_phone='" + hmePhone
										+ "',alter_phone='" + alterPhone + "',email='" + email + "',mari_status='"
										+ maritalStatus + "',spouse_name='" + spouseName + "',spouse_emp='" + spouseEmp
										+ "',spouse_mobile='" + spouseMobile + "',spouse_phone='" + spouseCno
										+ "',father_name='" + fthrName + "',father_occup='" + fthrOccup
										+ "',father_pno='" + fthrPno + "',father_work_location='" + fthrWorkLocation
										+ "',mother_name='" + mthrName + "',mother_occup='" + motherOccupation
										+ "',mother_pno='" + mthrPno + "',mother_work_location='" + mthrWorkLocation
										+ "',sibiling1_name='" + sib1Name + "',sibiling1_occupation='" + sib1Occup
										+ "',sibilling1_pno='" + sib1Pno + "',sibiling2_name='" + sib2Name
										+ "',sibiling3_name='" + sib3Name + "',sibiling2_occupation='" + sib2Occup
										+ "',sibilling2_pno='" + sib2Pno + "',sibiling3_occupation='" + sib3Occup
										+ "',sibiling3_pno='" + sib3Pno + "',sibiling4_name='" + sib4Name
										+ "',sibiling4_occupation='" + sib4Occup + "',sibiling4_pno='" + sib4Pno
										+ "',emg1_fullname='" + emg1Fullnme + "',emg1_PermAddress='" + emg1PermAddress
										+ "',emg1_City='" + emg1City + "',emg1_State='" + emg1State + "',emg1_Zip='"
										+ emg1Zip + "',emg1_homePno='" + emg1homePno + "',emg1_AlterPno='"
										+ emg1AlterPno + "',emg1_Relation='" + emg1Relation + "',emg2_Fullnme='"
										+ emg2Fullnme + "',emg2_permAddress='" + emg2permAddress + "',emg2_pcity='"
										+ emg2pcity + "',emg2_state='" + emg2state + "',emg2_zip='" + emg2zip
										+ "',emg2_homePno='" + emg2homePno + "',emg2_Relation='" + emg2Relation
										+ "',datetime='" + currdate + "' WHERE epf='80" + epf + "'";
								System.out.println(sql);
								try {
									rowaffected = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
									ResultSet rss = st.getGeneratedKeys();
									if (rss.next()) {
										risultato = rss.getInt(1);
										System.out.println(risultato + "getlastid");
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
								if (rowaffected > 0) {
									Notification.show("Data Updated Succesfully");
									sal.close();
									// loadtable();
									textField_epf.setValue("");
									textArea_padress.setValue("");
									textField_pcity.setValue("");
									textField_pstate.setValue("");
									textField_pzip.setValue("");
									textArea_taddress.setValue("");
									textField_tcity.setValue("");
									textField_tstate.setValue("");
									textField_tzip.setValue("");
									textField_homePhone.setValue("");
									textField_alterPhone.setValue("");
									textField_email.setValue("");
									comboBox_mart_status.setValue(null);
									textField_spouseName.setValue("");
									textField_spousEmp.setValue("");
									textField_spousePhone1.setValue("");
									textField_spousePhone.setValue("");
									textField_fName.setValue("");
									textField_fOccup.setValue("");
									textField_w_f_Pno.setValue("");
									textField_f_workloc.setValue("");
									textField_mName.setValue("");
									textField_m_occup.setValue("");
									textField__m_pno.setValue("");
									textField_sib21.setValue("");
									textField_m_wLoc.setValue("");
									textField_sib3.setValue("");
									textField_sib4.setValue("");
									textField_occ_s3.setValue("");
									textField_sib3_wpno.setValue("");
									textField_occ_sib4.setValue("");
									textField4_sib3_wpno.setValue("");
									textField_emg1Fullnme.setValue("");
									textArea_emg1PAddress.setValue("");
									textField_emg1_city.setValue("");
									textField_emg1_state.setValue("");
									textField_emg1_zip.setValue("");
									textField_emg1_hpno.setValue("");
									textField_emg1_alterpNo.setValue("");
									textField_emg1_reltion.setValue("");
									textField_emg2_fullName.setValue("");
									textField_emg2_city1.setValue("");
									textField_emg2_state.setValue("");
									textField_emg2_zip.setValue("");
									textField_emg2_hPno.setValue("");
									textField_emg2_relation.setValue("");
									textArea_emg2_paddress.setValue("");

								} else {
									Notification.show("Value Not Added");
									sal.close();
								}

							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								try {
									if (st != null) {
										st.close();
									}
									if (co != null) {
										co.close();
									}

								} catch (Exception e2) {
									// TODO: handle exception
									e2.printStackTrace();
								}
							}

						}
					});

					HR_Emp_Details_OK_CancelSub.button_CANCEL.addClickListener(new ClickListener() {

						@Override
						public void buttonClick(ClickEvent event) {
							// TODO Auto-generated method stub
							Notification.show("Not Completed");
							sal.close();
						}
					});
					sal.setContent(HR_Emp_Details_OK_CancelSub);

					sal.setWidth("300px");
					sal.setHeight("200px");
					sal.center();
					sal.setModal(true);
					sal.setResizable(false);
					UI.getCurrent().addWindow(sal);
				}

			}
		});

	}

	public void getUser12(String epf, String brh, int level, String usr, String brc) {
		// TODO Auto-generated method stub

		textField_epf.setValue(epf);
		// textField_NAME.setEnabled(false);
		// textField_BRANCH.setEnabled(false);
		// textField_NAME.setValue(usr);
		// textField_BRANCH.setValue(brh);

		username = usr;
		branch_name = brh;
		epf_no = epf;

		////////////////////////////////////////////////////
		Connection co = null;
		Statement st = null;

		try {

			int frepf = Integer.parseInt(epf_no.trim());
			String epf_no = new DecimalFormat("0000").format(frepf);

			// boolean epf_not=false;
			co = JDBC_MY.con();
			st = co.createStatement();
			ResultSet rsq = st.executeQuery(
					"SELECT E.emp_id,H.permanent_address,H.p_city,H.p_state,H.p_zip_code,H.temporary_address,H.t_city,H.t_state,H.t_zip_code,"
							+ "H.home_phone,H.alter_phone,H.email,H.mari_status,H.spouse_name,H.spouse_emp,H.spouse_mobile,H.spouse_phone,H.father_name,H.father_occup,H.father_pno,H.father_work_location,H.mother_name,H.mother_occup,H.mother_pno,"
							+ "H.mother_work_location,H.sibiling1_name,H.sibiling1_occupation,H.sibilling1_pno,H.sibiling2_name,H.sibiling2_occupation,H.sibilling2_pno,H.sibiling3_name,"
							+ "H.sibiling3_occupation,H.sibiling3_pno,H.sibiling4_name,H.sibiling4_occupation,H.sibiling4_pno,H.emg1_fullname,"
							+ "H.emg1_PermAddress,H.emg1_City,H.emg1_State,H.emg1_Zip,H.emg1_homePno,H.emg1_AlterPno,H.emg1_Relation,H.emg2_Fullnme,"
							+ "H.emg2_permAddress,H.emg2_pcity,H.emg2_state,H.emg2_zip,H.emg2_homePno,H.emg2_Relation,H.datetime FROM e_details.e_details E INNER JOIN e_details.hr_personal_details H ON E.emp_id=H.epf where  E.emp_id='80"
							+ epf_no + "'");

			if (rsq.next()) {

				String empid = rsq.getString("emp_id");
				String name = rsq.getString("permanent_address");
				String pCity = rsq.getString("p_city");
				String p_state = rsq.getString("p_state");
				String p_zip_code = rsq.getString("p_zip_code");
				String temporary_address = rsq.getString("temporary_address");
				String t_city = rsq.getString("t_city");
				String t_state = rsq.getString("t_state");
				String t_zip_code = rsq.getString("t_zip_code");
				String home_phone = rsq.getString("home_phone");
				String alter_phone = rsq.getString("alter_phone");
				String email = rsq.getString("email");
				String mari_status = rsq.getString("mari_status");
				String spouse_name = rsq.getString("spouse_name");
				String spouse_emp = rsq.getString("spouse_emp");
				String spouseMpno = rsq.getString("spouse_mobile");
				String spouse_phone = rsq.getString("spouse_phone");
				String father_name = rsq.getString("father_name");
				String father_occup = rsq.getString("father_occup");
				String father_pno = rsq.getString("father_pno");
				String father_work_location = rsq.getString("father_work_location");
				String mother_name = rsq.getString("mother_name");
				String motherOccupation = rsq.getString("mother_occup");
				String mother_pno = rsq.getString("mother_pno");
				String mother_work_location = rsq.getString("mother_work_location");
				String sibiling1_name = rsq.getString("sibiling1_name");
				String sibiling1_occupation = rsq.getString("sibiling1_occupation");
				String sibilling1_pno = rsq.getString("sibilling1_pno");
				String sibiling2_name = rsq.getString("sibiling2_name");
				String sibiling2_occupation = rsq.getString("sibiling2_occupation");
				String sibilling2_pno = rsq.getString("sibilling2_pno");
				String sibiling3_name = rsq.getString("sibiling3_name");
				String sibiling3_occupation = rsq.getString("sibiling3_occupation");
				String sibiling3_pno = rsq.getString("sibiling3_pno");
				String sibiling4_name = rsq.getString("sibiling4_name");
				String sibiling4_occupation = rsq.getString("sibiling4_occupation");
				String sibiling4_pno = rsq.getString("sibiling4_pno");
				String emg1_fullname = rsq.getString("emg1_fullname");
				String emg1_PermAddress = rsq.getString("emg1_PermAddress");
				String emg1_City = rsq.getString("emg1_City");
				String emg1_State = rsq.getString("emg1_State");
				String emg1_Zip = rsq.getString("emg1_Zip");
				String emg1_homePno = rsq.getString("emg1_homePno");
				String emg1_AlterPno = rsq.getString("emg1_AlterPno");
				String emg1_Relation = rsq.getString("emg1_Relation");
				String emg2_Fullnme = rsq.getString("emg2_Fullnme");
				String emg2_permAddress = rsq.getString("emg2_permAddress");
				String emg2_pcity = rsq.getString("emg2_pcity");
				String emg2_state = rsq.getString("emg2_state");
				String emg2_zip = rsq.getString("emg2_zip");
				String emg2_homePno = rsq.getString("emg2_homePno");
				String emg2_Relation = rsq.getString("emg2_Relation");
				String datetime = rsq.getString("datetime");

				System.out.println(rsq.getString("permanent_address"));

				// textField_epf.setEnabled(false);
				textField_epf.setValue(epf_no);
				if (level > 0 && level < 55) {
					if(!name.isEmpty()) {
						btn_submit.setVisible(false);
					}
					textArea_padress.setValue(name);
					textField_pcity.setValue(pCity);
					textField_pstate.setValue(p_state);
					textField_pzip.setValue(p_zip_code);
					textArea_taddress.setValue(temporary_address);
					textField_tcity.setValue(t_city);
					textField_tstate.setValue(t_state);
					textField_tzip.setValue(t_zip_code);
					textField_homePhone.setValue(home_phone);
					textField_alterPhone.setValue(alter_phone);
					textField_email.setValue(email);
					comboBox_mart_status.setValue(mari_status);
					textField_spouseName.setValue(spouse_name);
					textField_spousEmp.setValue(spouse_emp);
					textField_spousePhone.setValue(spouse_phone);
					textField_spousePhone1.setValue(spouseMpno);
					textField_fName.setValue(father_name);
					textField_fOccup.setValue(father_occup);
					textField_w_f_Pno.setValue(father_pno);
					textField_f_workloc.setValue(father_work_location);
					textField_mName.setValue(mother_name);
					textField_m_occup.setValue(motherOccupation);
					textField__m_pno.setValue(mother_pno);
					textField_m_wLoc.setValue(mother_work_location);
					textField_sib21.setValue(sibiling1_name);
					textField_occ_sib1.setValue(sibiling1_occupation);
					textField_wpno_s1.setValue(sibilling1_pno);
					textField_sib2.setValue(sibiling2_name);
					textField_sib2_occup.setValue(sibiling2_occupation);
					textField_sib2_wpno.setValue(sibilling2_pno);
					textField_sib3.setValue(sibiling3_name);
					textField_occ_s3.setValue(sibiling3_occupation);
					textField_sib3_wpno.setValue(sibiling3_pno);
					textField_sib4.setValue(sibiling4_name);
					textField_occ_sib4.setValue(sibiling4_occupation);
					textField4_sib3_wpno.setValue(sibiling4_pno);
					textField_emg1Fullnme.setValue(emg1_fullname);
					textArea_emg1PAddress.setValue(emg1_PermAddress);
					textField_emg1_city.setValue(emg1_City);
					textField_emg1_state.setValue(emg1_State);
					textField_emg1_zip.setValue(emg1_Zip);
					textField_emg1_hpno.setValue(emg1_homePno);
					textField_emg1_alterpNo.setValue(emg1_AlterPno);
					textField_emg1_reltion.setValue(emg1_Relation);
					textField_emg2_fullName.setValue(emg2_Fullnme);
					textArea_emg2_paddress.setValue(emg2_permAddress);
					textField_emg2_city1.setValue(emg2_pcity);
					textField_emg2_state.setValue(emg2_state);
					textField_emg2_zip.setValue(emg2_zip);
					textField_emg2_hPno.setValue(emg2_homePno);
					textField_emg2_relation.setValue(emg2_Relation);

				} else {
					textField_epf.setEnabled(false);
					button_srch.setVisible(false);
					if(!name.isEmpty()) {
						btn_submit.setVisible(false);
					}
					textArea_padress.setValue(name);
					textField_pcity.setValue(pCity);
					textField_pstate.setValue(p_state);
					textField_pzip.setValue(p_zip_code);
					textArea_taddress.setValue(temporary_address);
					textField_tcity.setValue(t_city);
					textField_tstate.setValue(t_state);
					textField_tzip.setValue(t_zip_code);
					textField_homePhone.setValue(home_phone);
					textField_alterPhone.setValue(alter_phone);
					textField_email.setValue(email);
					comboBox_mart_status.setValue(mari_status);
					textField_spouseName.setValue(spouse_name);
					textField_spousEmp.setValue(spouse_emp);
					textField_spousePhone.setValue(spouse_phone);
					textField_spousePhone1.setValue(spouseMpno);
					textField_fName.setValue(father_name);
					textField_fOccup.setValue(father_occup);
					textField_w_f_Pno.setValue(father_pno);
					textField_f_workloc.setValue(father_work_location);
					textField_mName.setValue(mother_name);
					textField__m_pno.setValue(mother_pno);
					textField_m_wLoc.setValue(mother_work_location);
					textField_sib21.setValue(sibiling1_name);
					textField_occ_sib1.setValue(sibiling1_occupation);
					textField_wpno_s1.setValue(sibilling1_pno);
					textField_sib2.setValue(sibiling2_name);
					textField_sib2_occup.setValue(sibiling2_occupation);
					textField_sib2_wpno.setValue(sibilling2_pno);
					textField_sib3.setValue(sibiling3_name);
					textField_occ_s3.setValue(sibiling3_occupation);
					textField_sib3_wpno.setValue(sibiling3_pno);
					textField_sib4.setValue(sibiling4_name);
					textField_occ_sib4.setValue(sibiling4_occupation);
					textField4_sib3_wpno.setValue(sibiling4_pno);
					textField_emg1Fullnme.setValue(emg1_fullname);
					textArea_emg1PAddress.setValue(emg1_PermAddress);
					textField_emg1_city.setValue(emg1_City);
					textField_emg1_state.setValue(emg1_State);
					textField_emg1_zip.setValue(emg1_Zip);
					textField_emg1_hpno.setValue(emg1_homePno);
					textField_emg1_alterpNo.setValue(emg1_AlterPno);
					textField_emg1_reltion.setValue(emg1_Relation);
					textField_emg2_fullName.setValue(emg2_Fullnme);
					textArea_emg2_paddress.setValue(emg2_permAddress);
					textField_emg2_city1.setValue(emg2_pcity);
					textField_emg2_state.setValue(emg2_state);
					textField_emg2_zip.setValue(emg2_zip);
					textField_emg2_hPno.setValue(emg2_homePno);
					textField_emg2_relation.setValue(emg2_Relation);

				}
				System.out.println();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (co != null) {
					co.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
	}

}
