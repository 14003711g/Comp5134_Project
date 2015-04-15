package comp5134.pos.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.swing.*;

import comp5134.pos.domain.Decorators;
import comp5134.pos.domain.Flavors;
import comp5134.pos.domain.Merchant;
import comp5134.pos.domain.Products;
import comp5134.pos.domain.Transaction;
import comp5134.pos.domain.TransactionDetail;
import comp5134.pos.system.SystemSetting;

/**
 * This is the main UI of POS
 * @author Raymond Kwan
 * @see Copyright Copyright of Raymond Kwan. All rights reserved.
 */
public class Pos extends JFrame implements ActionListener {
	final private String fontName = SystemSetting.fontName;
	final private int fontSize = SystemSetting.fontSize;
	final private int totolFontSize = SystemSetting.totolFontSize;
	
	private boolean isClickedNewTransaction = false;
	private String cashier = SystemSetting.cashier;
	private JPanel panelIcecreamItem;
	private JPanel panelDecoratorItem;
	private JTextField textAmount;
	
	private Merchant merchant;
	private ArrayList<Flavors> arrayListIcecream = new ArrayList<Flavors>();
	private ArrayList<Decorators> arrayListDecorator = new ArrayList<Decorators>();
	private ArrayList<Transaction> arrayListTransaction = new ArrayList<Transaction>();
	private ArrayList<TransactionDetail> arrayListTransactionDetail = new ArrayList<TransactionDetail>();

	private static final long serialVersionUID = -3042873665770420660L;
	
	/**
	 * This is used to create the POS UI instance
	 */
	public Pos()
	{
		super();
		merchant = new Merchant(SystemSetting.merchantId, SystemSetting.shopId, SystemSetting.shopName, SystemSetting.shopAddress, SystemSetting.shopTelephone);
		init();
		initProductItem();
	}	
	
	/**
	 * This function is used to update the total amount that will shown on screen
	 * @param unitPrice is a double
	 */
	private void updateTotalAmount(double unitPrice)
	{
		try
		{
			double newAmount = Double.parseDouble(textAmount.getText().substring(1)) + unitPrice;
			DecimalFormat dpFormat = new DecimalFormat("0.00"); 
			textAmount.setText("$ " + dpFormat.format(newAmount));
		}
		catch (Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Error to update total amount: " + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * This function is used to create all component on the UI
	 */
	private void init()
	{
		String title = merchant.getName() + " POS";
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		//Frame Setting
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(screenDimension.width*2/3, screenDimension.height/2);
		this.setLocationRelativeTo(null);
        //this.setAlwaysOnTop(true);
        this.setResizable(false);
        
        //Ice Cream Label
        JPanel panelIcecream = new JPanel();
        panelIcecream.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelIcecream.setPreferredSize(new Dimension(screenDimension.width*2/3, screenDimension.height/18)); //40
        panelIcecream.setBackground(Color.GREEN);
        JLabel lableIcecream = new JLabel("Ice-Cream Flavor");
        lableIcecream.setFont(new Font(fontName, Font.BOLD, fontSize));
        panelIcecream.add(lableIcecream);
        
        //Ice Cream Item
        panelIcecreamItem = new JPanel();
        panelIcecreamItem.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelIcecreamItem.setPreferredSize(new Dimension(screenDimension.width*2/3, (screenDimension.height/2)*3/18)); //80
        
        //Decorator Label
        JPanel panelDecorator = new JPanel();
        panelDecorator.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelDecorator.setPreferredSize(new Dimension(screenDimension.width*2/3, screenDimension.height/18));
        panelDecorator.setBackground(Color.PINK);
        JLabel lableDecorator = new JLabel("Decorator");
        lableDecorator.setFont(new Font(fontName, Font.BOLD, fontSize));
        panelDecorator.add(lableDecorator);
        
        //Decorator Item
        panelDecoratorItem = new JPanel();
        panelDecoratorItem.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelDecoratorItem.setPreferredSize(new Dimension(screenDimension.width*2/3, (screenDimension.height/2)*3/18));
        
        //System Admin & New Transaction
        JPanel panelSystemFunction = new JPanel();
        panelSystemFunction.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelSystemFunction.setPreferredSize(new Dimension(screenDimension.width*2/3, (screenDimension.height/2)/9)); //80
        
        //System Admin
        JButton btnSystemAdmin = new JButton("System Administrator");
        btnSystemAdmin.addActionListener(
        		new ActionListener() 
        		{
        			public void actionPerformed(ActionEvent e) 
        			{
        				String[] aryItem = new String[] {"Flavor", "Decorator"};
                        JPanel panelProductInput = new JPanel();
                        panelProductInput.setLayout(new BoxLayout(panelProductInput, BoxLayout.Y_AXIS));
                        panelProductInput.add(new JLabel("New Item"));
						JComboBox comboItem = new JComboBox(aryItem);
                        panelProductInput.add(comboItem);
                        panelProductInput.add(Box.createVerticalStrut(15));
                        panelProductInput.add(new JLabel("Item Name"));
                        JTextField textItemName = new JTextField();
                        panelProductInput.add(textItemName);
                        panelProductInput.add(Box.createVerticalStrut(15));
                        panelProductInput.add(new JLabel("Unit Price"));
                        JTextField textUnitPrice = new JTextField("0");
                        panelProductInput.add(textUnitPrice);
                        panelProductInput.add(Box.createVerticalStrut(20));
                        int rtnval = JOptionPane.showConfirmDialog(null, panelProductInput, "New Item", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
                        
                        if (rtnval == JOptionPane.OK_OPTION)
                        {
                        	try
                        	{
	                        	if (comboItem.getSelectedIndex() == 0)
	                        	{
	                        		Flavor f = new Flavor(textItemName.getText(), Double.parseDouble(textUnitPrice.getText()));
	                        		f.setEnabled(true); //f.setEnabled(isClickedNewTransaction);
	                        		f.addActionListener(Pos.this);
	                        		panelIcecreamItem.add(f);
	                        		panelIcecreamItem.validate();
		                    		panelIcecreamItem.repaint();
	                        	}
	                        	
	                        	if (comboItem.getSelectedIndex() == 1)
	                        	{
	                        		Decorator d = new Decorator(textItemName.getText(), Double.parseDouble(textUnitPrice.getText()));
	                        		d.setEnabled(true); //d.setEnabled(isClickedNewTransaction);
	                        		d.addActionListener(Pos.this);
	                        		panelDecoratorItem.add(d);
	                        		panelDecoratorItem.validate();
		                    		panelDecoratorItem.repaint();
	                        	}
                        	}
                        	catch (Exception ex)
                        	{
                        		JOptionPane.showMessageDialog(Pos.this, "Error to add new item: " + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                        	}
                        }
        			}
        		}
        );
        
        //New Transaction
        JButton btnNewTransaction = new JButton("New IceCream");
        btnNewTransaction.addActionListener(
        		new ActionListener()
        		{
        			public void actionPerformed(ActionEvent e) 
        			{
        				isClickedNewTransaction = true;
        				
        				//Store a new transaction record with details
        				double transactionAmount = Double.parseDouble(Pos.this.textAmount.getText().substring(1));
        				SimpleDateFormat displayFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        				
        				if (transactionAmount > 0)
        				{
        					Iterator iProduct;
        					Products selectedProducts;
        					int transactionId = arrayListTransaction.size() + 1;
        					arrayListTransaction.add(new Transaction(transactionId, transactionAmount, displayFormat.format(Calendar.getInstance().getTime()), cashier));
        					
        					//Ice cream flavor details
        					iProduct = arrayListIcecream.iterator();
        					while(iProduct.hasNext())
        					{
        						selectedProducts = (Products)iProduct.next();
        						arrayListTransactionDetail.add(new TransactionDetail(transactionId, "f", selectedProducts.getName(), selectedProducts.getUnitPrice()));
        					}
        					
        					//Decorator details
        					iProduct = arrayListDecorator.iterator();
        					while(iProduct.hasNext())
        					{
        						selectedProducts = (Products)iProduct.next();
        						arrayListTransactionDetail.add(new TransactionDetail(transactionId, "d", selectedProducts.getName(), selectedProducts.getUnitPrice()));
        					}
        				
                            iProduct = null;
        				}
        				
        				//Set the product button to enable
                        Component[] collectionIcecream = Pos.this.panelIcecreamItem.getComponents();
                        for (int i=0; i < collectionIcecream.length; i++)
                        {
                        	if (collectionIcecream[i] instanceof Product)
                        	{
                        		collectionIcecream[i].setEnabled(true);
                        	}
                        }
                        
                        Component[] collectionDecorator = Pos.this.panelDecoratorItem.getComponents();
                        for (int i=0; i < collectionDecorator.length; i++)
                        {
                        	if (collectionDecorator[i] instanceof Product)
                        	{
                        		collectionDecorator[i].setEnabled(true);
                        	}
                        }
                        
                        //Reset to the new transaction status
                        arrayListIcecream.clear();
                        arrayListDecorator.clear();
                        Pos.this.textAmount.setText("$ 0.0");
        			}
        		}
        );
        
        panelSystemFunction.add(btnSystemAdmin);
        panelSystemFunction.add(btnNewTransaction);
        
        //Total Panel
        JPanel panelTotal = new JPanel();
        panelTotal.setLayout(new FlowLayout(FlowLayout.TRAILING)); //RIGTH
        panelTotal.setPreferredSize(new Dimension(screenDimension.width*2/3, (screenDimension.height/2)*1/9)); //80
        JLabel lableTotal = new JLabel("TOTAL");
        lableTotal.setFont(new Font(fontName, Font.BOLD, totolFontSize));
        panelTotal.add(lableTotal);

        textAmount = new JTextField(5);
        textAmount.setText("$ 0.0");
        textAmount.setEditable(false);
        textAmount.setFont(new Font(fontName, Font.BOLD, totolFontSize));
        textAmount.setBackground(Color.RED);
        panelTotal.add(textAmount);
        
        this.setLayout(new FlowLayout());
        this.add(panelIcecream);
        this.add(panelIcecreamItem);
        this.add(panelDecorator);
        this.add(panelDecoratorItem);
        this.add(panelSystemFunction);
        this.add(panelTotal);
        
        this.setVisible(true);
	}

	/**
	 * This is used to initial two ice-cream flavors and two decorators button on UI when the POS starts
	 */
	private void initProductItem()
	{
		Flavor flavorChocolate = new Flavor("Chocolate", 20); 
		Flavor flavorVanilla = new Flavor("Vanilla", 15);
		flavorChocolate.setEnabled(true);
		flavorVanilla.setEnabled(true);
		flavorChocolate.addActionListener(this);
		flavorVanilla.addActionListener(this);
		panelIcecreamItem.add(flavorChocolate);
		panelIcecreamItem.add(flavorVanilla);
		
		Decorator decoratorMM = new Decorator("M&M", 5);
		Decorator decoratorStrawberry = new Decorator("Strawberry", 4);
		decoratorMM.setEnabled(true);
		decoratorStrawberry.setEnabled(true);
		decoratorMM.addActionListener(this);
		decoratorStrawberry.addActionListener(this);
		panelDecoratorItem.add(decoratorMM);
		panelDecoratorItem.add(decoratorStrawberry);
	}

	/**
	 * Button listener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try
		{
			Product p = (Product)e.getSource();
			
			if (e.getSource() instanceof Flavor)
			{
				Flavors newItem = new Flavors(p.getName(), p.getUnitPrice());
				if (newItem.checkOverLimit(arrayListIcecream.size()))
				{
					JOptionPane.showMessageDialog(this, "Only one Ice-cream flavor can be chosen for each transaction", "Ice-cream", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				else
				{
					this.updateTotalAmount(p.getUnitPrice());
					arrayListIcecream.add(newItem);
				}
			}
			else
			{
				Decorators newItem = new Decorators(p.getName(), p.getUnitPrice());
				if (newItem.checkOverLimit(arrayListDecorator.size()))
				{
					JOptionPane.showMessageDialog(this, "Over the number of selected decorator can be chosen for each transaction", "Decorator", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				else
				{
					this.updateTotalAmount(p.getUnitPrice());
					arrayListDecorator.add(newItem);
				}
			}
		}
		catch (Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Error to add Ice-cream flavor or decorator: " + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}